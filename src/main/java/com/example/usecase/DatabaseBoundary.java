package com.example.usecase;

import java.sql.SQLException;

public interface DatabaseBoundary {


    String updateProductDienMay(RequestData requestData) throws SQLException;

    String updateProductThucPham(RequestData requestData) throws SQLException;

    String updateProductSanhSu(RequestData requestData) throws SQLException;

    int getTotalQuantityDienMay() throws SQLException;

    int getTotalQuantitySanhSu() throws SQLException;

    int getTotalQuantityThucPham() throws SQLException;
}
