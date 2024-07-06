package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item save(Item item) {
		return this.itemRepository.save(item);
	}

	@Override
	public Item update(UUID id, Item item) {
		Optional<Item> itemOptional = this.itemRepository.findById(id);
		
		if (itemOptional.isPresent()) {
			Item existingItem = itemOptional.get();
			existingItem.setNombre(item.getNombre());
			
			return this.itemRepository.save(existingItem);
		} else {
			throw new IllegalArgumentException("Item not found with id: " + id);
		}
	}

	@Override
	public List<Item> getAll() {
		return this.itemRepository.findAll();
	}

	@Override
	public Optional<Item> findById(UUID id) {
		return this.itemRepository.findById(id);
	}

	@Override
	public ResponseEntity<Item> deleteById(UUID id) {
		Optional<Item> itemOptional = this.itemRepository.findById(id);
		
		if (itemOptional.isPresent()) {
			this.itemRepository.delete(itemOptional.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public Page<Item> get(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("nombre")); 
		return this.itemRepository.findAll(pageRequest);
	}
}
