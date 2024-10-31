package com.fidel.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import com.fidel.demo.component.*;
import com.fidel.demo.dto.ProductDTO;
import com.fidel.demo.entities.Product;
import com.fidel.demo.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    final private IProductRepository repository;
    final private Environment environment;
    final private NotificationService notification;

    public ProductServiceImpl(IProductRepository repository, Environment environment, NotificationService notification){
        this.repository = repository;
        this.environment = environment;
        this.notification = notification;
    }

    @Override
    public List<ProductDTO> findAll() {
            List<ProductDTO> productList = ((List<Product>)repository.findAll()).stream().map(product ->{
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCreateAt(), product.getPort());
        }).collect(Collectors.toList());

        if (productList.isEmpty()) {
            throw new ResourceNotFoundException("Sin Registros");
        }

        this.notification.sendNotification("Puerto seteado correctamente en la obtencion del listado");
        return productList;
    }

}
