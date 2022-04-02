package vn.cg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import vn.cg.model.Music;
import vn.cg.model.MusicForm;
import vn.cg.service.HibernateMusicService;
import vn.cg.service.IMusicService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/song")
public class MusicController {

    private IMusicService musicService = new HibernateMusicService();

    @RequestMapping()
    public String home(Model model) {
        List<Music> musics = musicService.findAll();
        model.addAttribute("musics", musics);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", new MusicForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String folderUpload;

    @PostMapping("/save")
    public ModelAndView saveMusic(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getSound();
        String folderName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(musicForm.getSound().getBytes(), new File(folderUpload));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getNameSong(), musicForm.getSinger(), musicForm.getCategory(), folderName);
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("folderName", folderName);
        modelAndView.addObject("message", "CREATE NEW MUSIC SUCCESSFULLY");
        return modelAndView;
    }
}
