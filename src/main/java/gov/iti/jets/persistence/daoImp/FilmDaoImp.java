package gov.iti.jets.persistence.daoImp;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.persistence.dao.FilmDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.*;
import gov.iti.jets.service.mapper.FilmActorMapper;
import gov.iti.jets.service.mapper.FilmCategoryMapper;
import gov.iti.jets.service.mapper.FilmMapper;
import gov.iti.jets.service.mapper.InventoryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

public class FilmDaoImp  extends BaseDAO implements FilmDao{
    private FilmMapper filmMapper;
    private FilmActorMapper filmActorMapper;
    private FilmCategoryMapper filmCategoryMapper;
    private InventoryMapper inventoryMapper;

    public FilmDaoImp(){
        filmMapper = Mappers.getMapper(FilmMapper.class);
        filmActorMapper = Mappers.getMapper(FilmActorMapper.class);
        filmCategoryMapper = Mappers.getMapper(FilmCategoryMapper.class);
        inventoryMapper = Mappers.getMapper(InventoryMapper.class);
    }
    @Override
    public Boolean createFilm(FilmDto film) {
        return null;
    }

    private Film film;
    @Override
    public FilmDto getFilmById(int id) {
        film = getById(id);
        return filmMapper.toDto(film);
    }

    @Override
    public Boolean updateFilm(FilmDto filmDto) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Film film = filmMapper.toEntity(filmDto);
            entityManager.getTransaction().begin();
            entityManager.merge(film);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean deleteFilm(int id) {
        return null;
    }

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> filmList = getAll(Film.class);
        return filmList.stream().map((film -> filmMapper.toDto(film))).toList();
    }

    @Override
    public List<InventoryDto> getInventoryListByFilm(int id) {
        film = getById(id);
        List<Inventory> inventoryList = film.getInventoryList();
        List<InventoryDto> inventoryDtoList = inventoryList.stream().map((inventory -> inventoryMapper.toDto(inventory))).toList();
        return inventoryDtoList;
    }

    @Override
    public List<FilmActorDto> getfilmActorList(int id) {
        film = getById(id);
        List<FilmActor> filmActorList = film.getFilmActorList();
        List<FilmActorDto> filmCategoryDtoList = filmActorList.stream().map((filmActor -> filmActorMapper.toDto(filmActor))).toList();
        return filmCategoryDtoList;
    }

    @Override
    public List<FilmCategoryDto> getfilmCategoryList(int id) {
        film = getById(id);
        List<FilmCategory> filmCategoryList = film.getFilmCategoryList();
        List<FilmCategoryDto> filmCategoryDtoList = filmCategoryList.stream().map((filmCategory -> filmCategoryMapper.toDto(filmCategory))).toList();
        return filmCategoryDtoList;
    }

    private Film getById(int id){
        return (Film) get(Film.class,"filmId",id);
    }

}
