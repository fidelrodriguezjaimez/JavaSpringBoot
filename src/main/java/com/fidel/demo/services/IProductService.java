package com.fidel.demo.services;

import com.fidel.demo.dto.*;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();
}
