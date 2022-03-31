package vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world-clock")
    public String getTimeZone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // lấy ra thời gian hiện tại
        Date date = new Date();

        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();

        // Lấy ra time zone của thanh phố
        TimeZone locale = TimeZone.getTimeZone(city);

        // tính thời gian hiện tại của thành phố
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());

        // cài đặt thời gian cho biến date thành tgian cụ thể
        date.setTime(locale_time);

        // chuyển dữ liệu qua view
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "index";
    }

    @GetMapping("/")
    public String getZo() {
        return "index";
    }
}
