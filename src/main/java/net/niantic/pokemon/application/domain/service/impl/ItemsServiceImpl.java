package net.niantic.pokemon.application.domain.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.entities.ItemsEntity;
import net.niantic.pokemon.application.domain.repository.ItemsRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.ItemsDTO;
import net.niantic.pokemon.application.domain.rest.exception.ResourceNotFoundException;
import net.niantic.pokemon.application.domain.rest.forms.ItemsForm;
import net.niantic.pokemon.application.domain.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;
    private final TrainerRepository trainerRepository;

    //CREATE
    @Transactional
    public void createItems(ItemsForm itemsForm){
        ItemsEntity itemsEntity = new ItemsEntity();
        itemsEntity.setName(itemsForm.getName());
        itemsEntity.setDescription(itemsForm.getDescription());
        itemsEntity.setCategory(itemsForm.getCategory());
        itemsEntity.setBasePower(itemsForm.getBasePower());
        itemsEntity.setTrainerId(itemsForm.getTrainerId());
        this.itemsRepository.save(itemsEntity);
    }

    //READ
    public List<ItemsDTO> getAllItems(){
        List<ItemsEntity> itemsEntities = itemsRepository.findAll();
        if(itemsEntities.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Items not found");
        return ItemsDTO.convertToDTO(itemsEntities);
    }

    //UPDATE
    public void updateItems(ItemsForm itemsForm, Long id){
        Optional<ItemsEntity> itemsEntity = itemsRepository.findById(id);
        ItemsEntity itemUpdated = itemsEntity.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        itemsRepository.save(convertFormToEntity(itemsForm, id));
    }

    public ItemsEntity convertFormToEntity(ItemsForm itemsForm, Long id){
        ItemsEntity itemsEntity = new ItemsEntity();
        itemsEntity.setId(id);
        itemsEntity.setName(itemsForm.getName());
        itemsEntity.setDescription(itemsForm.getDescription());
        itemsEntity.setCategory(itemsForm.getCategory());
        itemsEntity.setBasePower(itemsForm.getBasePower());
        itemsEntity.setTrainer(
                trainerRepository
                    .findById(itemsForm.getTrainerId())
                    .orElseThrow( () -> new ResourceNotFoundException("Trainer not found")));
        return itemsEntity;
    }

    @Override
    public void deleteItems(Long id) {
        itemsRepository.deleteById(id);
    }
}
