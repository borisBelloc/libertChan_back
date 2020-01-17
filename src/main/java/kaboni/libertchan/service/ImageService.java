package kaboni.libertchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaboni.libertchan.dao.ImageJpaRepository;
import kaboni.libertchan.models.Image;

@Service
public class ImageService {

	@Autowired
	private ImageJpaRepository repository;
	
	public Optional<Image> findById(Long id){
		return repository.findById(id);
	}
	
	public List<Image> findAll(){
		return repository.findAll();
	}
	
	public Image save(Image image) {
		return repository.save(image);
	}
	
	public void delete(Image image) {
		repository.delete(image);
	}
	
}
