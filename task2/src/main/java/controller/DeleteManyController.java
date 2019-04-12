package controller;

import dao.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StuService;

@Controller
public class DeleteManyController {
    @Autowired
    StuService stuService;
    @RequestMapping("deleteMany")
    public String deleteMany(int[] chk_value){
        if(null==chk_value){
            return "redirect:/";
        }
        stuService.deleteaMany(chk_value);
        return "redirect:/";
    }
}
