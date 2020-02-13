package kaboni.libertchan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kaboni.libertchan.models.Image;
import kaboni.libertchan.service.ImageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Image> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Image findById(@PathVariable Long id) {
		return service.findById(id).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Image save(@PathVariable Image image) {
		return service.save(image);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@PathVariable Image image) {
		service.delete(image);
	}
	
}
