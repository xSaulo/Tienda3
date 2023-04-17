package com.tecno.tecno.Service.impl;

import com.tienda_l.dao.ArticuloDao;
import com.tienda_l.domain.Articulo;
import com.tienda_l.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laboratorios
 */
@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulos(boolean activos) {
        return (List<Articulo>) articuloDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Articulo getArticulo(Articulo articulo) {
       return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
 
}
