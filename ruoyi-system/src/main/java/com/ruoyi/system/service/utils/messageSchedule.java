package com.ruoyi.system.service.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.ruoyi.system.domain.family.FamilyPopuBase;
import com.ruoyi.system.mapper.family.FamilyPopuBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther al
 * Date 2020/10/26 0026
 */
@Component
public class messageSchedule {

    @Autowired
    private FamilyPopuBaseMapper popuBaseMapper;

    @Scheduled(fixedDelay = 5000)
    public void messageSchedule() {
        //提前一周查询生日名单
        List<FamilyPopuBase> list = popuBaseMapper.list(null);
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        String toDay = String.valueOf(year) + String.valueOf(month < 10 ? '0' +String.valueOf(month) : month) + String.valueOf(day < 10 ? '0' + String.valueOf(day) : day);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        list.forEach(entity -> {
            try {
                String s = ChinaDate.lunarToSolar(entity.getBirthday(), false);
                StringBuilder bir = new StringBuilder();
                Arrays.asList(s.split("-")).forEach(e -> {
                    bir.append(e);
                });
                Date birthday = format.parse(bir.toString());
                Date Tody = format.parse(toDay);
                if (differentDays(birthday,Tody) == 1) {
                    seedMsg(entity.getName(), s);
                }
                bir.delete(0, bir.length() - 1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }

    public static void seedMsg(String name, String date) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G2pto3TCmNFpbgR78Mf", "S9kpcjcBBZwhuFYu3RAyLZnJi49syd");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "13564545562");
        request.putQueryParameter("SignName", "ABC商城");
        request.putQueryParameter("TemplateCode", "SMS_205811609");
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("time", date);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //不同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //同一年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
