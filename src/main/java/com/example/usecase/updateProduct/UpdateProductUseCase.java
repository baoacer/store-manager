package com.example.usecase.updateProduct;

import com.example.dtos.DienMayDTO;
import com.example.dtos.SanhSuDTO;
import com.example.dtos.ThucPhamDTO;
import com.example.usecase.*;
import com.example.usecase.updateProduct.OutputDTO.UpdateDienMayOutPutDTO;
import com.example.usecase.updateProduct.OutputDTO.UpdateSanhSuOutputDTO;
import com.example.usecase.updateProduct.OutputDTO.UpdateThucPhamOutputDTO;

import java.sql.SQLException;

public class UpdateProductUseCase implements InputBoundary {

    private DatabaseBoundary databaseBoundary = null;
    private OutputBoundary outputBoundary = null;

    public UpdateProductUseCase(DatabaseBoundary databaseBoundary, OutputBoundary outputBoundary) {
        this.databaseBoundary = databaseBoundary;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(RequestData requestData) throws SQLException {
        if (requestData instanceof DienMayDTO) {
            String message = databaseBoundary.updateProductDienMay(requestData);
            ResponseData responseData = new UpdateDienMayOutPutDTO(message);
            outputBoundary.exportResult(responseData);
        } else if (requestData instanceof SanhSuDTO) {
           String message = databaseBoundary.updateProductSanhSu(requestData);
            ResponseData responseData = new UpdateSanhSuOutputDTO(message);
            outputBoundary.exportResult(responseData);
        } else if (requestData instanceof ThucPhamDTO) {
            String message = databaseBoundary.updateProductThucPham(requestData);
            ResponseData responseData = new UpdateThucPhamOutputDTO(message);
            outputBoundary.exportResult(responseData);
        }
    }
}
