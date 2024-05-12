package com.ddh.sales.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.util.Date;

import com.ddh.sales.bean.Product;
import com.ddh.sales.bean.Sales;
import com.ddh.sales.service.Administrator;

import java.text.SimpleDateFormat;

public class ApplicationFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicationFrame frame = new ApplicationFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ApplicationFrame() {
        setTitle("Satış ve Stok Takibi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnStokEkle = new JButton("ÜRÜN EKLE");
        btnStokEkle.setBounds(10, 10, 150, 100);
        contentPane.add(btnStokEkle);

        btnStokEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame stokEkleFrame = new JFrame("Ürün Ekle");
                stokEkleFrame.setBounds(100, 100, 300, 250);
                JPanel panel = new JPanel();
                stokEkleFrame.getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel = new JLabel("Ürün İsmi:");
                lblNewLabel.setBounds(10, 10, 80, 25);
                panel.add(lblNewLabel);

                JTextField productNameField = new JTextField();
                productNameField.setBounds(100, 10, 150, 25);
                panel.add(productNameField);

                JLabel lblNewLabel_1 = new JLabel("Stok Miktarı:");
                lblNewLabel_1.setBounds(10, 45, 80, 25);
                panel.add(lblNewLabel_1);

                JTextField quantityField = new JTextField();
                quantityField.setBounds(100, 45, 150, 25);
                panel.add(quantityField);

                JLabel lblNewLabel_2 = new JLabel("Adet Fiyatı:");
                lblNewLabel_2.setBounds(10, 80, 80, 25);
                panel.add(lblNewLabel_2);

                JTextField unitPriceField = new JTextField();
                unitPriceField.setBounds(100, 80, 150, 25);
                panel.add(unitPriceField);

                JLabel lblNewLabel_3 = new JLabel("Yeniden Sipariş Seviyesi:");
                lblNewLabel_3.setBounds(10, 115, 200, 25);
                panel.add(lblNewLabel_3);

                JTextField reorderLevelField = new JTextField();
                reorderLevelField.setBounds(160, 115, 90, 25);
                panel.add(reorderLevelField);

                JButton applyButton = new JButton("Uygula");
                applyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Product stock = new Product();
                        String productName = productNameField.getText();
                        stock.setProductName(productName);
                        String QuantityonHand = quantityField.getText();
                        int IntQuantityonHand = Integer.parseInt(QuantityonHand);
                        stock.setQuantityonHand(IntQuantityonHand);
                        String ProductUnitPrice = unitPriceField.getText();
                        double doubleProductUnitPrice = Double.parseDouble(ProductUnitPrice);
                        stock.setProductUnitPrice(doubleProductUnitPrice);
                        String ReorderLevel = reorderLevelField.getText();
                        int IntReorderLevel = Integer.parseInt(ReorderLevel);
                        stock.setReorderLevel(IntReorderLevel); 
                        
                        Administrator administrator = new Administrator();
						JOptionPane.showMessageDialog(null, "Product ID " + administrator.insertStock(stock) + " eklendi.");
                        stokEkleFrame.dispose(); 
                    }
                });
                applyButton.setBounds(10, 150, 80, 25);
                panel.add(applyButton);

                JButton cancelButton = new JButton("İptal");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stokEkleFrame.dispose(); 
                    }
                });
                cancelButton.setBounds(100, 150, 80, 25);
                panel.add(cancelButton);

                stokEkleFrame.setVisible(true);
            }
        });
        
        JButton btnStokGor = new JButton("STOK GÖRÜNTÜLE");
        btnStokGor.setBounds(195, 153, 200, 100);
        contentPane.add(btnStokGor);
        
        btnStokGor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame raporFrame = new JFrame("Stok Görüntüle");
                raporFrame.setBounds(100, 100, 700, 400);
                JPanel panel = new JPanel();
                raporFrame.getContentPane().add(panel);
                panel.setLayout(new BorderLayout());
        		Administrator administrator = new Administrator();
        		String[] columnNames = {"Product_ID", "Ürün Adı", "Stok Miktarı", "Maliyet", "Yeniden Sipariş Seviyesi"};
        		Object[][] data = new Object[administrator.getStockReport().size()][columnNames.length];
        		for (int i = 0; i < administrator.getStockReport().size(); i++) {
        		    data[i][0] = administrator.getStockReport().get(i).getProductID();
        		    data[i][1] = administrator.getStockReport().get(i).getProductName();
        		    data[i][2] = administrator.getStockReport().get(i).getQuantityonHand();
        		    data[i][3] = administrator.getStockReport().get(i).getProductUnitPrice();
        		    data[i][4] = administrator.getStockReport().get(i).getReorderLevel();
        		}
        		JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                panel.add(scrollPane, BorderLayout.CENTER);

                JButton backButton = new JButton("GERİ DÖN");
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        raporFrame.dispose(); 
                    }
                });
                panel.add(backButton, BorderLayout.SOUTH);

                raporFrame.setVisible(true);
            }
        });
        
        
        
        
        
       
        JButton btnStokSil = new JButton("ÜRÜN SİL");
        btnStokSil.setBounds(10, 153, 150, 100);
        contentPane.add(btnStokSil);
        
        btnStokSil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame stokSilFrame = new JFrame("Ürün Sil");
                stokSilFrame.setBounds(100, 100, 300, 200);
                JPanel panel = new JPanel();
                stokSilFrame.getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel = new JLabel("Silinecek Ürüne Ait ProductID:");
                lblNewLabel.setBounds(10, 10, 180, 25);
                panel.add(lblNewLabel);

                JTextField productIdField = new JTextField();
                productIdField.setBounds(10, 40, 180, 25);
                panel.add(productIdField);

                JButton applyButton = new JButton("Uygula");
                applyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Administrator administrator = new Administrator();
                        String str = productIdField.getText();
                        String str1 = administrator.deleteStock(str);
                        if (str1 != null)
                        	JOptionPane.showMessageDialog(null, str1);
                        stokSilFrame.dispose();
                    }
                });
                applyButton.setBounds(10, 80, 80, 25);
                panel.add(applyButton);

                JButton cancelButton = new JButton("Geri Dön");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stokSilFrame.dispose(); 
                    }
                });
                cancelButton.setBounds(100, 80, 100, 25);
                panel.add(cancelButton);

                stokSilFrame.setVisible(true);
            }
        });

        JButton btnSatRaporu = new JButton("SATIŞ RAPORU");
        btnSatRaporu.setBounds(426, 153, 150, 100);
        contentPane.add(btnSatRaporu);
        
        btnSatRaporu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame raporFrame = new JFrame("Satış Raporu");
                raporFrame.setBounds(100, 100, 600, 400);
                JPanel panel = new JPanel();
                raporFrame.getContentPane().add(panel);
                panel.setLayout(new BorderLayout());
                Administrator administrator = new Administrator();
                String[] columnNames = {"SALES_ID", "SATIŞ TARİHİ", "PRODUCT_ID", "ÜRÜN ADI", "SATILAN ADET", "BİRİM FİYATI", "BİRİM SATIŞ FİYATI", "KAR-ZARAR"};

                Object[][] data = new Object[administrator.getSalesReport().size()][columnNames.length];

                for (int i = 0; i < administrator.getSalesReport().size(); i++) {
                    data[i][0] = administrator.getSalesReport().get(i).getSalesID();
                    data[i][1] = administrator.getSalesReport().get(i).getSalesDate();
                    data[i][2] = administrator.getSalesReport().get(i).getProductID();
                    data[i][3] = administrator.getSalesReport().get(i).getProductName();
                    data[i][4] = administrator.getSalesReport().get(i).getQuantitySold();
                    data[i][5] = administrator.getSalesReport().get(i).getProductUnitPrice();
                    data[i][6] = administrator.getSalesReport().get(i).getSalesPricePerUnit();
                    data[i][7] = administrator.getSalesReport().get(i).getProfitAmount();
                }

                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                panel.add(scrollPane, BorderLayout.CENTER);

                JButton backButton = new JButton("GERİ DÖN");
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        raporFrame.dispose(); 
                    }
                });
                panel.add(backButton, BorderLayout.SOUTH);

                raporFrame.setVisible(true);
            }
        });


        JButton btnStokDeg = new JButton("STOK EKLE/ÇIKAR");
        btnStokDeg.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnStokDeg.setBounds(195, 10, 200, 100);
        contentPane.add(btnStokDeg);
        
        btnStokDeg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame stokDegFrame = new JFrame("Stok Ekle/Çıkar");
                stokDegFrame.setBounds(100, 100, 300, 200);
                JPanel panel = new JPanel();
                stokDegFrame.getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel = new JLabel("Stoğu Değiştirilecek Ürüne Ait ProductID:");
                lblNewLabel.setBounds(10, 10, 250, 25);
                panel.add(lblNewLabel);

                JTextField productIdField = new JTextField();
                productIdField.setBounds(10, 40, 250, 25);
                panel.add(productIdField);
                
                JLabel lblNewLabel_1 = new JLabel("Eklenecek Stok Miktarı:");
                lblNewLabel_1.setBounds(10, 80, 150, 25);
                panel.add(lblNewLabel_1);

                JTextField quantityField = new JTextField();
                quantityField.setBounds(150, 80, 110, 25);
                panel.add(quantityField);

                JButton applyButton = new JButton("Uygula");
                applyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Administrator administrator = new Administrator();
                        String str = productIdField.getText();
                        String str1 = quantityField.getText();
                        int int1 = Integer.parseInt(str1);
                        String str2 = administrator.incrementStock(str, int1);
                        if (str2 != null)
                        	JOptionPane.showMessageDialog(null, str1 + " " + str2);
                        stokDegFrame.dispose();
                    }
                });
                applyButton.setBounds(10, 130, 80, 25);
                panel.add(applyButton);

                JButton cancelButton = new JButton("Geri Dön");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stokDegFrame.dispose(); 
                    }
                });
                cancelButton.setBounds(100, 130, 100, 25);
                panel.add(cancelButton);

                stokDegFrame.setVisible(true);
            }
        });
        
        
        
        JButton btnSatEkle = new JButton("SATIŞ EKLE");
        btnSatEkle.setBounds(426, 10, 150, 100);
        contentPane.add(btnSatEkle);
        
        
        btnSatEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame satisEkleFrame = new JFrame("Satış Ekle");
                satisEkleFrame.setBounds(100, 100, 300, 250);
                JPanel panel = new JPanel();
                satisEkleFrame.getContentPane().add(panel);
                panel.setLayout(null);

                JLabel lblNewLabel1 = new JLabel("Tarih Girin (GG-AA-YYYY):");
                lblNewLabel1.setBounds(10, 10, 180, 25);
                panel.add(lblNewLabel1);

                JTextField dateField = new JTextField();
                dateField.setBounds(200, 10, 80, 25);
                panel.add(dateField);

                JLabel lblNewLabel2 = new JLabel("Product ID:");
                lblNewLabel2.setBounds(10, 45, 80, 25);
                panel.add(lblNewLabel2);

                JTextField productIdField = new JTextField();
                productIdField.setBounds(200, 45, 80, 25);
                panel.add(productIdField);

                JLabel lblNewLabel3 = new JLabel("Satılan Adet:");
                lblNewLabel3.setBounds(10, 80, 80, 25);
                panel.add(lblNewLabel3);

                JTextField quantitySoldField = new JTextField();
                quantitySoldField.setBounds(200, 80, 80, 25);
                panel.add(quantitySoldField);

                JLabel lblNewLabel4 = new JLabel("Adet Fiyatı:");
                lblNewLabel4.setBounds(10, 115, 80, 25);
                panel.add(lblNewLabel4);

                JTextField salesPricePerUnitField = new JTextField();
                salesPricePerUnitField.setBounds(200, 115, 80, 25);
                panel.add(salesPricePerUnitField);

                JButton applyButton = new JButton("Uygula");
                applyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Administrator administrator = new Administrator();
                    	try {
                    	Sales sales = new Sales();
                        String date1 = dateField.getText();
                        Date date;
						date = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
						sales.setSalesDate(date);
	                    String productId = productIdField.getText();
	                    sales.setProductId(productId);
	                    String quantitySold = quantitySoldField.getText();
	                    int IntquantitySold = Integer.parseInt(quantitySold);
	                    sales.setQuantitySold(IntquantitySold);
	                    String salesPricePerUnit = salesPricePerUnitField.getText();
	                    double doublesalesPricePerUnit = Double.parseDouble(salesPricePerUnit);
	                    sales.setSalesPriceperUnit(doublesalesPricePerUnit);
	                    JOptionPane.showMessageDialog(null, administrator.insertSales(sales));
	                    
						} catch (Exception E) {
							E.printStackTrace();
						}
                        

                    }
                });
                applyButton.setBounds(10, 150, 80, 25);
                panel.add(applyButton);

                JButton cancelButton = new JButton("Geri Dön");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        satisEkleFrame.dispose(); 
                    }
                });
                cancelButton.setBounds(100, 150, 100, 25);
                panel.add(cancelButton);

                satisEkleFrame.setVisible(true);
                
                
            }
        });

    }
}
