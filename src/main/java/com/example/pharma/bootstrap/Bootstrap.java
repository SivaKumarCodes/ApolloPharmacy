//package com.example.pharma.bootstrap;
//
//import com.example.pharma.Domain.*;
//import com.example.pharma.Repository.*;
//import lombok.AllArgsConstructor;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//import java.io.FileInputStream;
//
//@Component
//@Transactional
//@AllArgsConstructor
//public class Bootstrap implements CommandLineRunner {
//    private UserRepository userRepository;
//    private HighlightRepository highlightRepository;
//
//    private ProductImagesRepository productImagesRepository;
//    private ProductRepository productRepository;
//
//    private VariantRepository variantRepository;
//
//    public Bootstrap(UserRepository userRepository, HighlightRepository highlightRepository, ProductRepository productRepository , ProductImagesRepository productImagesRepository , VariantRepository variantRepository) {
//        this.userRepository = userRepository;
//        this.highlightRepository = highlightRepository;
//        this.productRepository = productRepository;
//        this.productImagesRepository = productImagesRepository;
//    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        String variantFile = "/home/siva/jee/jakartaee-tutorial-examples/web/servlet/pharma/src/main/resources/sheets/variants.xlsx";
//
//        FileInputStream variantStream = new FileInputStream(variantFile);
//
//        XSSFWorkbook variantWorkbook = new XSSFWorkbook(variantStream);
//        XSSFSheet variantSheet = variantWorkbook.getSheetAt(0);
//        int rows = variantSheet.getLastRowNum();
//
//        Product p;
//        for(long i = 0 ; i < rows ; i++){
//            XSSFRow row = variantSheet.getRow((int)i);
//            int cell = row.getLastCellNum();
//            p = productRepository.findById(i+1).orElseThrow(null);
//
//            Variant v = new Variant((int)(row.getCell(1).getNumericCellValue()) , (int)(row.getCell(2).getNumericCellValue()),p);
//
//            if(cell > 3) {
//                Variant v2 = new Variant((int) (row.getCell(3).getNumericCellValue()), (int) (row.getCell(4).getNumericCellValue()), p);
//                variantRepository.save(v2);
//            }
//
//            variantRepository.save(v);
//
//        }
//    }

    //    @Override
//    public void run(String... args) throws Exception {
//
//        highlightRepository.deleteAll();
//        productImagesRepository.deleteAll();
//        productRepository.deleteAll();
//
//        if(productRepository.count() < 1){
//        String productfile = "/home/siva/jee/jakartaee-tutorial-examples/web/servlet/pharma/src/main/resources/sheets/product.xlsx";
//
//        FileInputStream productInputStream = new FileInputStream(productfile);
//
//        XSSFWorkbook productWorkbook = new XSSFWorkbook(productInputStream);
//        XSSFSheet productSheet = productWorkbook.getSheetAt(0);
//
//        int rows = productSheet.getLastRowNum();
//
//        Product product;
//        Highlight highlight;
//            ProductImages p ;
//
//            for (int i = 0; i < rows; i++) {
//            XSSFRow row = productSheet.getRow(i);
//            int cells = row.getLastCellNum();
//
//            product = new Product(row.getCell(0).getStringCellValue(), PackagingType.valueOf(row.getCell(1).getStringCellValue()), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue());
//
//            Product savedProduct = productRepository.save(product);
//
//            for (int j = 4; j < 8; j++) {
//                highlight = new Highlight(row.getCell(j).getStringCellValue(), savedProduct);
//                highlightRepository.save(highlight);
//            }
//
//            for(int k = 8 ; k < cells ; k++){
//
//                if(row.getCell(k) != null) {
//                    System.out.println("@@@@@@@@@@@@@@@@@ " + i + " " + k + "\n");
//                    switch (row.getCell(k).getCellType()){
//                        case STRING ->
//                        {p = new ProductImages (String.valueOf(row.getCell(k).getStringCellValue()).toString() , savedProduct);
//                                productImagesRepository.save(p);
//                                break;}
//
//                        case NUMERIC -> { p = new ProductImages(Integer.toString((int)(row.getCell(k).getNumericCellValue())), savedProduct);
//                            productImagesRepository.save(p); }
//                        }
//                    }
//                }
//            }
//        }
//    }
//if(userRepo) {
//    String userfile = "/home/siva/jee/jakartaee-tutorial-examples/web/servlet/pharma/src/main/resources/sheets/users.xlsx";
//
//    FileInputStream userInputStream = new FileInputStream(userfile);
//
//    XSSFWorkbook userWorkbook = new XSSFWorkbook(userInputStream);
//
//    XSSFSheet userSheet = userWorkbook.getSheetAt(0);
//
//    int numrows = userSheet.getLastRowNum();
//
//    for (int i = 0; i < numrows; i++) {
//        XSSFRow row = userSheet.getRow(i);
//
//        int numCells = row.getLastCellNum();
//
//
//        User user = new User(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue());
//
//        userRepository.save(user);
//    }
//}
//    }
//}