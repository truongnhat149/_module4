package vn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @RequestMapping("/world-clock")
    public String getTimezone(@RequestParam(name = "city", required = false) String city, ModelMap modelMap) {
        // khời tạo đối tượng lấy tgian hiện tại
        Date date = new Date();

        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();

        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);

        // Tính thời gian hiện tại của một thành phố cụ thể
        long locale_time = date.getTime() + (locale.getRawOffset() - locale.getRawOffset());

        // cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố
        date.setTime(locale_time);

        // chuyển dữ liệu qua view
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "index";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
