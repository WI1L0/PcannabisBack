package com.cannabis.BackCannabis.Services.ServicesImpl;

import com.cannabis.BackCannabis.Dtos.*;
import com.cannabis.BackCannabis.Modelos.Productos;
import com.cannabis.BackCannabis.Repository.IProductosRepository;
import com.cannabis.BackCannabis.Services.IServices.IProductosServices;
import com.cannabis.BackCannabis.excepciones.ResourceNotFoundExeptionLong;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServicesImpl implements IProductosServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductosRepository repository;


    @Override
    public ProductosDtos FindByIdS(Long Id) {
        Productos productos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Productos", "Id", Id));
        return mapearDTO(productos);
    }

    @Override
    public ProductosDtos SaveS(ProductosDtos dtos) {
        Productos productos = repository.save(mapearEntidad(dtos));
        return mapearDTO(productos);
    }

    @Override
    public ProductosDtos UpdateS(Long Id, ProductosDtos dtos) {
        Productos productos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Productos", "Id", Id));

        productos.setAltoProducto(dtos.getAltoProducto());
        productos.setAnchoProducto(dtos.getAnchoProducto());
        productos.setDescripcionProducto(dtos.getDescripcionProducto());
        productos.setEstProducto(dtos.getEstProducto());
        productos.setModeloProducto(dtos.getModeloProducto());
        productos.setNombreProducto(dtos.getNombreProducto());
        productos.setPreDescripcionProducto(dtos.getPreDescripcionProducto());
        productos.setStockProducto(dtos.getStockProducto());

        return mapearDTO(repository.save(productos));
    }

    @Override
    public void DeleteS(Long Id) {
        Productos productos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Productos", "Id", Id));
        repository.delete(productos);
    }

    @Override
    public void LogicoDeleteS(Long Id) {
        Productos productos = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundExeptionLong("Productos", "Id", Id));

        productos.setEstProducto(!productos.getEstProducto());

        repository.save(productos);
    }


    @Override
    public ProductosRespuestaDto FindAllPaginacionS(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Productos> productos = repository.findAll(pageable);

        List<Productos> listaProductos = productos.getContent();
        List<ProductosDtos> contenido = listaProductos.stream().map(producto -> mapearDTO(producto)).collect(Collectors.toList());

        ProductosRespuestaDto productosRespuestaDto = new ProductosRespuestaDto();
        productosRespuestaDto.setContenido(contenido);
        productosRespuestaDto.setNumeroPagina(productos.getNumber());
        productosRespuestaDto.setMedidaPagina(productos.getSize());
        productosRespuestaDto.setTotalElementos(productos.getTotalElements());
        productosRespuestaDto.setTotalPagina(productos.getTotalPages());
        productosRespuestaDto.setUltima(productos.isLast());

        return productosRespuestaDto;
    }

    @Override
    public List<ProductosDtos> FindAllByEmpresasId(Long Id) {
        List<ProductosDtos> productosDtosList = new ArrayList<>();
        repository.findByEmpresasRP(Id).forEach(data -> productosDtosList.add(mapearDTO(data)));
        return productosDtosList;
    }


    //    METODOS REUTILIZABLES
    private Productos mapearEntidad(ProductosDtos Dto) {
        //        CONVERTIMOS DE ENTIDAD A DTO
        return modelMapper.map(Dto, Productos.class);
    }

    private ProductosDtos mapearDTO(Productos entity){
        //        CONVERTIMOS DE DTO A ENTIDAD
        return modelMapper.map(entity, ProductosDtos.class);
    }

}
