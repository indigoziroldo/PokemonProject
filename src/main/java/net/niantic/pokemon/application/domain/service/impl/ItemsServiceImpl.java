package net.niantic.pokemon.application.domain.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.niantic.pokemon.application.domain.entities.ItemsEntity;
import net.niantic.pokemon.application.domain.repository.ItemsRepository;
import net.niantic.pokemon.application.domain.repository.TrainerRepository;
import net.niantic.pokemon.application.domain.rest.dto.ItemsDTO;
import net.niantic.pokemon.application.domain.rest.forms.ItemsForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsServiceImpl {

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
        this.itemsRepository.save(itemsEntity);
    }

    //READ
    public List<ItemsDTO> getAllItems(){
        List<ItemsEntity> itemsEntities = itemsRepository.findAll();
        if(itemsEntities.isEmpty()) throw new RuntimeException("No items found");
        return ItemsDTO.convertToDTO(itemsEntities);
    }

    //UPDATE
    public void updateItems(ItemsForm itemsForm, Long id){
        Optional<ItemsEntity> itemsEntity = itemsRepository.findById(id);
        if(itemsEntity.isEmpty()) throw new RuntimeException("This item does not exist");
        itemsRepository.save(convertFormToEntity(itemsForm, id));
    }

    public ItemsEntity convertFormToEntity(ItemsForm itemsForm, Long id){
        ItemsEntity itemsEntity = new ItemsEntity();
        itemsEntity.setId(id);
        itemsEntity.setName(itemsForm.getName());
        itemsEntity.setDescription(itemsForm.getDescription());
        itemsEntity.setCategory(itemsForm.getCategory());
        itemsEntity.setBasePower(itemsForm.getBasePower());
        itemsEntity.setTrainer(trainerRepository.findById(id).get(itemsForm.getTrainerId()));
        return itemsEntity;
    }

    public void deleteItemsById(Long id){
        itemsRepository.deleteById(id);
    }
}
