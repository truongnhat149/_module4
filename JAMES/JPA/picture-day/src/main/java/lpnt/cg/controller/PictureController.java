package lpnt.cg.controller;

import lpnt.cg.model.Picture;
import lpnt.cg.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PictureController {

    @Autowired
    private IPictureService pictureService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("picture", new Picture());
        List<Picture> pictures = pictureService.findAll();
        modelAndView.addObject("pictures", pictures);
        return modelAndView;
    }

    @PostMapping
    public String save(Picture picture) {
        pictureService.save(picture);
        return "redirect:/home";
    }

    @PostMapping(value = "like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Picture> like(@PathVariable(name = "id") Long id) {
        Picture comment = pictureService.like(id);
        System.out.println(comment.getLikeCount());
        if (comment == null) {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}

