package com.example;

import java.sql.SQLException;

import com.example.database.MySqlDAO;
import com.example.dtos.DienMayDTO;
import com.example.ui.Presenter;
import com.example.usecase.DatabaseBoundary;
import com.example.usecase.RequestData;
import com.example.usecase.totalQuantityDienMay.TotalQuantityDienMayOutputDTO;
import com.example.usecase.totalQuantityDienMay.TotalQuantityUseCase;
import com.example.usecase.updateProduct.OutputDTO.UpdateDienMayOutPutDTO;
import com.example.usecase.updateProduct.UpdateProductUseCase;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class GetTotalQuantityProductsTest {
    @Test
    public void testGetTotalQuantityProducts() throws SQLException {
        DatabaseBoundary databaseBoundary = new MySqlDAO();
        Presenter presenter = new Presenter();
        TotalQuantityUseCase totalQuantityUseCase = new TotalQuantityUseCase(databaseBoundary, presenter);
        RequestData requestData = new DienMayDTO();
        totalQuantityUseCase.execute(requestData);
        TotalQuantityDienMayOutputDTO totalQuantityDienMayOutputDTO = (TotalQuantityDienMayOutputDTO) presenter.getResponseData();
        assertEquals(33, totalQuantityDienMayOutputDTO.getTotalQuantity());
    }

    @Test
    public void updateProduct() throws SQLException {
        DatabaseBoundary databaseBoundary = new MySqlDAO();
        Presenter presenter = new Presenter();
        UpdateProductUseCase updateProductUseCase = new UpdateProductUseCase(databaseBoundary, presenter);
        RequestData requestData = new DienMayDTO("H001", "Television", 10, 200000, 2, 20);
        updateProductUseCase.execute(requestData);
        UpdateDienMayOutPutDTO updateDienMayOutPutDTO = (UpdateDienMayOutPutDTO) presenter.getResponseData();
        assertEquals("Dien may cap nhat thanh cong!", updateDienMayOutPutDTO.getMessage());
    }
}
