package Views;

import Model.Configuracion;
import Model.Detalle;
import Model.Producto;
import Model.ProductoDAO;
import Model.Proveedor;
import Model.ProveedorDAO;
import Model.Venta;
import Model.VentaDAO;
import Reports.Excel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    Proveedor pr = new Proveedor();
    ProveedorDAO prDAO = new ProveedorDAO();
    Producto pd = new Producto();
    ProductoDAO pdDAO = new ProductoDAO();
    Venta v = new Venta();
    VentaDAO vDAO = new VentaDAO();
    Detalle dv = new Detalle();
    Configuracion conf = new Configuracion();
    
    int item;
    double tPagar = 0.0;

    public Inventory() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/logo.png")).getImage());
        txtIdVenta.setVisible(false);
        txtIdConf.setVisible(false);
        txtIdVentas.setVisible(false);
        listarConfiguracion();
    }
    
    public void listarProveedores() {
        List<Proveedor> listPr = prDAO.listarProvvedor();
        model = (DefaultTableModel) tableProveedor.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < listPr.size(); i++) {
            obj[0] = listPr.get(i).getRfc();
            obj[1] = listPr.get(i).getNombre();
            obj[2] = listPr.get(i).getDireccion();
            obj[3] = listPr.get(i).getTelefono();
            model.addRow(obj);
        }
        tableProveedor.setModel(model);
    }
    
    public void listarProducto() {
        List<Producto> listPr = pdDAO.listarProducto();
        model = (DefaultTableModel) tableProducto.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < listPr.size(); i++) {
            obj[0] = listPr.get(i).getCodigo();
            obj[1] = listPr.get(i).getNombre();
            obj[2] = listPr.get(i).getStock();
            obj[3] = listPr.get(i).getPrecio();
            obj[4] = listPr.get(i).getProveedor();
            model.addRow(obj);
        }
        tableProducto.setModel(model);
    }
    
    public void listarConfiguracion() {
        conf = pdDAO.buscarDatos();
        txtIdConf.setText(conf.getId()+"");
        txtRfcConf.setText(conf.getRfc()+"");
        txtNombreConf.setText(conf.getNombre()+"");
        txtTelefonoConf.setText(conf.getTelefono()+"");
        txtDireccionConf.setText(conf.getDireccion()+"");
    }
    
    public void listarVenta() {
        List<Venta> listVent = vDAO.listarVenta();
        model = (DefaultTableModel) tableVentas.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < listVent.size(); i++) {
            obj[0] = listVent.get(i).getId();
            obj[1] = listVent.get(i).getVendedor();
            obj[2] = listVent.get(i).getTotal();
            model.addRow(obj);
        }
        tableVentas.setModel(model);
    }
    
    public void limpiarTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        txtTitle = new javax.swing.JLabel();
        Navigation = new javax.swing.JPanel();
        btnNuevaVenta = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnConfiguracion = new javax.swing.JButton();
        txtVendedor = new javax.swing.JLabel();
        routes = new javax.swing.JTabbedPane();
        panelNuevaVenta = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        txtDescripcionVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStockDisponible = new javax.swing.JTextField();
        btnEliminarVenta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVenta = new javax.swing.JTable();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        panelProveedores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnGuardarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        panelProductos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtCantProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        cbxProveedorProducto = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        txtNombreProducto = new javax.swing.JTextField();
        btnGuardarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        btnExcelProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        panelVentas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        btnPdfVenta = new javax.swing.JButton();
        txtIdVentas = new javax.swing.JTextField();
        panelConfiguracion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRfcConf = new javax.swing.JTextField();
        txtNombreConf = new javax.swing.JTextField();
        txtTelefonoConf = new javax.swing.JTextField();
        txtDireccionConf = new javax.swing.JTextField();
        btnActualizarConf = new javax.swing.JButton();
        lblConfiguracion = new javax.swing.JLabel();
        txtIdConf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Product Sans", 0, 10)); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N

        txtTitle.setBackground(new java.awt.Color(102, 102, 102));
        txtTitle.setFont(new java.awt.Font("Product Sans Medium", 0, 22)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(51, 51, 51));
        txtTitle.setText("Abarrotes Victor");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(imgLogo)
                .addGap(342, 342, 342)
                .addComponent(txtTitle)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLogo))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtTitle)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 80));

        Navigation.setBackground(new java.awt.Color(15, 175, 81));

        btnNuevaVenta.setBackground(new java.awt.Color(15, 175, 81));
        btnNuevaVenta.setFont(new java.awt.Font("Product Sans Medium", 0, 12)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setBorder(null);
        btnNuevaVenta.setFocusPainted(false);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(15, 175, 81));
        btnProveedores.setFont(new java.awt.Font("Product Sans Medium", 0, 12)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
        btnProveedores.setFocusPainted(false);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(15, 175, 81));
        btnProductos.setFont(new java.awt.Font("Product Sans Medium", 0, 12)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setFocusPainted(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(15, 175, 81));
        btnVentas.setFont(new java.awt.Font("Product Sans Medium", 0, 12)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setBorder(null);
        btnVentas.setFocusPainted(false);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(new java.awt.Color(15, 175, 81));
        btnConfiguracion.setFont(new java.awt.Font("Product Sans Medium", 0, 12)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.setBorder(null);
        btnConfiguracion.setFocusPainted(false);
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        txtVendedor.setForeground(new java.awt.Color(15, 175, 81));
        txtVendedor.setText("Abarrotes Victor");

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        getContentPane().add(Navigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, 130, 530));

        routes.setBackground(new java.awt.Color(255, 255, 255));

        panelNuevaVenta.setBackground(new java.awt.Color(229, 255, 238));

        lblCodigo.setText("Codigo");

        lblDescripcion.setText("Descripcion");

        lblCantidad.setText("Cantidad");

        lblPrecio.setText("Precio");

        lblStock.setText("Stock Disponible");

        txtCodigoVenta.setPreferredSize(new java.awt.Dimension(64, 25));
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
        });

        txtDescripcionVenta.setEditable(false);
        txtDescripcionVenta.setPreferredSize(new java.awt.Dimension(64, 25));

        txtCantidadVenta.setPreferredSize(new java.awt.Dimension(64, 25));
        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
        });

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setPreferredSize(new java.awt.Dimension(64, 25));

        txtStockDisponible.setEditable(false);
        txtStockDisponible.setPreferredSize(new java.awt.Dimension(64, 25));

        btnEliminarVenta.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminarVenta.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnEliminarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVenta.setText("Eliminar Producto");
        btnEliminarVenta.setPreferredSize(new java.awt.Dimension(24, 25));
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        tableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableVenta);
        if (tableVenta.getColumnModel().getColumnCount() > 0) {
            tableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableVenta.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        btnGenerarVenta.setBackground(new java.awt.Color(15, 175, 81));
        btnGenerarVenta.setFont(new java.awt.Font("Product Sans Black", 0, 12)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.setBorder(null);
        btnGenerarVenta.setFocusPainted(false);
        btnGenerarVenta.setFocusable(false);
        btnGenerarVenta.setPreferredSize(new java.awt.Dimension(200, 35));
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel14.setText("Total a Pagar");

        lblTotalVenta.setFont(new java.awt.Font("Product Sans", 1, 15)); // NOI18N
        lblTotalVenta.setText("00.00");

        javax.swing.GroupLayout panelNuevaVentaLayout = new javax.swing.GroupLayout(panelNuevaVenta);
        panelNuevaVenta.setLayout(panelNuevaVentaLayout);
        panelNuevaVentaLayout.setHorizontalGroup(
            panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(40, 40, 40)
                        .addComponent(lblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                                .addComponent(lblStock)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                                .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        panelNuevaVentaLayout.setVerticalGroup(
            panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(lblDescripcion)
                            .addComponent(lblCantidad)
                            .addComponent(lblPrecio)
                            .addComponent(lblStock)))
                    .addGroup(panelNuevaVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelNuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(lblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        routes.addTab("Nueva Venta", panelNuevaVenta);

        panelProveedores.setBackground(new java.awt.Color(229, 255, 238));

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel1.setText("RFC");

        jLabel2.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel3.setText("Direccion");

        jLabel4.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel4.setText("Telefono");

        txtRFC.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtNombreProveedor.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtDireccionProveedor.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtTelefonoProveedor.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        btnGuardarProveedor.setBackground(new java.awt.Color(15, 137, 175));
        btnGuardarProveedor.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnGuardarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.setBorder(null);
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setBackground(new java.awt.Color(175, 159, 15));
        btnActualizarProveedor.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnActualizarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setBackground(new java.awt.Color(175, 15, 15));
        btnEliminarProveedor.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnNuevoProveedor.setBackground(new java.awt.Color(15, 175, 81));
        btnNuevoProveedor.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnNuevoProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProveedor.setText("Nuevo");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFC", "Nombre", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProveedor);
        if (tableProveedor.getColumnModel().getColumnCount() > 0) {
            tableProveedor.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableProveedor.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableProveedor.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout panelProveedoresLayout = new javax.swing.GroupLayout(panelProveedores);
        panelProveedores.setLayout(panelProveedoresLayout);
        panelProveedoresLayout.setHorizontalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProveedoresLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(172, 241, Short.MAX_VALUE))
                            .addGroup(panelProveedoresLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1)
                                            .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnActualizarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtRFC))))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addComponent(txtNombreProveedor)
                        .addGap(18, 18, 18))
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addComponent(txtTelefonoProveedor)
                        .addGap(18, 18, 18))
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelProveedoresLayout.setVerticalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        routes.addTab("Proveedores", panelProveedores);

        panelProductos.setBackground(new java.awt.Color(229, 255, 238));
        panelProductos.setMinimumSize(new java.awt.Dimension(64, 24));

        jLabel5.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel5.setText("Codigo");

        jLabel6.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel8.setText("Precio");

        jLabel9.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel9.setText("Proveedor");

        txtCodigoProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        txtCodigoProducto.setPreferredSize(new java.awt.Dimension(70, 25));

        txtCantProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        txtCantProducto.setPreferredSize(new java.awt.Dimension(70, 25));

        txtPrecioProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        txtPrecioProducto.setPreferredSize(new java.awt.Dimension(70, 25));

        cbxProveedorProducto.setEditable(true);
        cbxProveedorProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        cbxProveedorProducto.setMinimumSize(new java.awt.Dimension(64, 24));

        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Precio", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProducto);
        if (tableProducto.getColumnModel().getColumnCount() > 0) {
            tableProducto.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableProducto.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableProducto.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableProducto.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableProducto.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        txtNombreProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        txtNombreProducto.setPreferredSize(new java.awt.Dimension(64, 25));

        btnGuardarProducto.setBackground(new java.awt.Color(15, 137, 175));
        btnGuardarProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        btnGuardarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnActualizarProducto.setBackground(new java.awt.Color(175, 159, 15));
        btnActualizarProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        btnActualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnNuevoProducto.setBackground(new java.awt.Color(15, 175, 81));
        btnNuevoProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        btnNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProducto.setText("Nuevo");
        btnNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProductoActionPerformed(evt);
            }
        });

        btnExcelProducto.setBackground(new java.awt.Color(15, 175, 81));
        btnExcelProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        btnExcelProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnExcelProducto.setText("Excel");
        btnExcelProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(175, 15, 15));
        btnEliminarProducto.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductosLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxProveedorProducto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelProductosLayout.createSequentialGroup()
                                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(txtCantProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(btnNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcelProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductosLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(116, 116, 116)
                                .addComponent(jLabel7)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel9)
                                .addGap(136, 136, 136)))
                        .addComponent(btnExcelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelProductosLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(txtCantProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(cbxProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGuardarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        routes.addTab("Productos", panelProductos);

        panelVentas.setBackground(new java.awt.Color(229, 255, 238));

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vendedor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableVentas);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
        }

        btnPdfVenta.setBackground(new java.awt.Color(175, 15, 15));
        btnPdfVenta.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnPdfVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnPdfVenta.setText("PDF");
        btnPdfVenta.setBorder(null);
        btnPdfVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addComponent(btnPdfVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtIdVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPdfVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtIdVentas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        routes.addTab("Ventas", panelVentas);

        panelConfiguracion.setBackground(new java.awt.Color(229, 255, 238));

        jLabel10.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel10.setText("RFC");

        jLabel11.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel11.setText("Nombre De La Empresa");

        jLabel12.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel13.setText("Direccion");

        txtRfcConf.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtNombreConf.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtTelefonoConf.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        txtDireccionConf.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N

        btnActualizarConf.setBackground(new java.awt.Color(15, 175, 81));
        btnActualizarConf.setFont(new java.awt.Font("Product Sans Black", 0, 14)); // NOI18N
        btnActualizarConf.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarConf.setText("Actualizar");

        lblConfiguracion.setFont(new java.awt.Font("Product Sans Medium", 0, 24)); // NOI18N
        lblConfiguracion.setText("Datos De La Empresa");

        javax.swing.GroupLayout panelConfiguracionLayout = new javax.swing.GroupLayout(panelConfiguracion);
        panelConfiguracion.setLayout(panelConfiguracionLayout);
        panelConfiguracionLayout.setHorizontalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(panelConfiguracionLayout.createSequentialGroup()
                        .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtRfcConf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoConf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(lblConfiguracion)
                            .addComponent(jLabel13)
                            .addComponent(txtNombreConf, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(txtDireccionConf)))
                    .addComponent(btnActualizarConf, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        panelConfiguracionLayout.setVerticalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracionLayout.createSequentialGroup()
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConfiguracionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblConfiguracion))
                    .addGroup(panelConfiguracionLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(txtIdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfcConf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreConf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoConf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionConf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(btnActualizarConf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        routes.addTab("Configuracion", panelConfiguracion);

        getContentPane().add(routes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 900, 530));

        setSize(new java.awt.Dimension(1040, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        if(!"".equals(txtRFC.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText())){
            pr.setRfc(txtRFC.getText());
            pr.setNombre(txtNombreProveedor.getText());
            pr.setDireccion(txtDireccionProveedor.getText());
            pr.setTelefono(txtTelefonoProveedor.getText());
            prDAO.registrarProveedor(pr);
            JOptionPane.showMessageDialog(null, "Proveedor Guardado");
            limpiarTable();
            limpiarTxtProveedor();
            listarProveedores();
        } else {
            JOptionPane.showMessageDialog(null, "No Deje Campos Vacios");
        }
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        routes.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        limpiarTable();
        listarProveedores();
        routes.setSelectedIndex(1);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
        int fila = tableProveedor.rowAtPoint(evt.getPoint());
        txtRFC.setText(tableProveedor.getValueAt(fila, 0).toString());
        txtNombreProveedor.setText(tableProveedor.getValueAt(fila, 1).toString());
        txtDireccionProveedor.setText(tableProveedor.getValueAt(fila, 2).toString());
        txtTelefonoProveedor.setText(tableProveedor.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tableProveedorMouseClicked

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        if(!"".equals(txtRFC.getText())){
            int question = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
            if(question == 0){
                String rfc = txtRFC.getText();
                prDAO.eliminarProveedor(rfc);
                JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
                limpiarTable();
                limpiarTxtProveedor();
                listarProveedores();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
        if(!"".equals(txtRFC.getText())){
            if(!"".equals(txtNombreProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText())){
                pr.setNombre(txtNombreProveedor.getText());
                pr.setDireccion(txtDireccionProveedor.getText());
                pr.setTelefono(txtTelefonoProveedor.getText());
                pr.setRfc(txtRFC.getText());
                prDAO.modificarProveedor(pr);
                JOptionPane.showMessageDialog(null, "Proveedor Actualizado");
                limpiarTable();
                limpiarTxtProveedor();
                listarProveedores();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        limpiarTxtProveedor();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        if(!"".equals(txtCodigoProducto.getText()) || !"".equals(txtNombreProducto.getText()) || !"".equals(txtCantProducto.getText()) || !"".equals(txtPrecioProducto.getText()) || !"".equals(cbxProveedorProducto.getSelectedItem())){
            pd.setCodigo(txtCodigoProducto.getText());
            pd.setNombre(txtNombreProducto.getText());
            pd.setStock(Integer.parseInt(txtCantProducto.getText()));
            pd.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
            pd.setProveedor((String) cbxProveedorProducto.getSelectedItem());
            pdDAO.registrarProducto(pd);
            JOptionPane.showMessageDialog(null, "Producto Guardado");
            limpiarTable();
            limpiarTxtProducto();
            listarProducto();
        } else {
            JOptionPane.showMessageDialog(null, "No Deje Campos Vacios");
        }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        limpiarTable();
        listarProducto();
        cbxProveedorProducto.removeAllItems();
        cbxProveedorProducto.setSelectedItem("");
        pdDAO.consultarProveedor(cbxProveedorProducto);
        routes.setSelectedIndex(2);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void tableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductoMouseClicked
        int fila = tableProducto.rowAtPoint(evt.getPoint());
        txtCodigoProducto.setText(tableProducto.getValueAt(fila, 0).toString());
        txtNombreProducto.setText(tableProducto.getValueAt(fila, 1).toString());
        txtCantProducto.setText(tableProducto.getValueAt(fila, 2).toString());
        txtPrecioProducto.setText(tableProducto.getValueAt(fila, 3).toString());
        cbxProveedorProducto.setSelectedItem(tableProducto.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tableProductoMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if(!"".equals(txtCodigoProducto.getText())){
            int question = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar");
            if(question == 0){
                String codigo = txtCodigoProducto.getText();
                pdDAO.eliminarProducto(codigo);
                JOptionPane.showMessageDialog(null, "Proveedor Eliminado");
                limpiarTable();
                limpiarTxtProducto();
                listarProducto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        if(!"".equals(txtCodigoProducto.getText())){
            if(!"".equals(txtNombreProducto.getText()) || !"".equals(txtCantProducto.getText()) || !"".equals(txtPrecioProducto.getText()) || !"".equals(cbxProveedorProducto.getSelectedItem())){
                pd.setNombre(txtNombreProducto.getText());
                pd.setStock(Integer.parseInt(txtCantProducto.getText()));
                pd.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
                pd.setProveedor((String) cbxProveedorProducto.getSelectedItem());
                pd.setCodigo(txtCodigoProducto.getText());
                pdDAO.modificarProducto(pd);
                JOptionPane.showMessageDialog(null, "Producto Actualizado");
                limpiarTable();
                limpiarTxtProducto();
                listarProducto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProductoActionPerformed
        limpiarTxtProducto();
    }//GEN-LAST:event_btnNuevoProductoActionPerformed

    private void btnExcelProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelProductoActionPerformed
        Excel.reporte();
    }//GEN-LAST:event_btnExcelProductoActionPerformed

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!"".equals(txtCodigoVenta.getText())){
                String codigo = txtCodigoVenta.getText();
                pd = pdDAO.buscarPorducto(codigo);
                if(pd.getNombre() != null){
                    txtDescripcionVenta.setText(pd.getNombre());
                    txtPrecioVenta.setText(pd.getPrecio()+"");
                    txtStockDisponible.setText(pd.getStock()+"");
                    txtCantidadVenta.requestFocus();
                } else {
                    limpiarTxtVenta();
                    txtCodigoVenta.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese El Codigo del Producto");
                txtCodigoVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!"".equals(txtCantidadVenta.getText())) {
                String codigo = txtCodigoVenta.getText();
                String descripcion = txtDescripcionVenta.getText();
                int cantidad = Integer.parseInt(txtCantidadVenta.getText());
                double precio = Double.parseDouble(txtPrecioVenta.getText());
                int stock = Integer.parseInt(txtStockDisponible.getText());
                double total = cantidad * precio;
                if(stock >= cantidad ){
                    item = item + 1;
                    tmp = (DefaultTableModel) tableVenta.getModel();
                    for (int i = 0; i < tableVenta.getRowCount(); i++) {
                        if(tableVenta.getValueAt(i, 1).equals(txtDescripcionVenta.getText())){
                            JOptionPane.showMessageDialog(null, "El Producto ya Esta Registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(codigo);
                    lista.add(descripcion);
                    lista.add(cantidad);
                    lista.add(precio);
                    lista.add(total);
                    Object[] obj = new Object[5];
                    obj[0] = lista.get(1);
                    obj[1] = lista.get(2);
                    obj[2] = lista.get(3);
                    obj[3] = lista.get(4);
                    obj[4] = lista.get(5);
                    tmp.addRow(obj);
                    tableVenta.setModel(tmp);
                    totalPagar();
                    limpiarTxtVenta();
                    txtCodigoVenta.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock No Disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        model = (DefaultTableModel) tableVenta.getModel();
        model.removeRow(tableVenta.getSelectedRow());
        totalPagar();
        txtCodigoVenta.requestFocus();
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        registrarVenta();
        registrarDetalle();
        PDF();
        actualizarStocK();
        limpiarTableVentas();
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        limpiarTable();
        listarVenta();
        routes.setSelectedIndex(3);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked
        int fila = tableVentas.rowAtPoint(evt.getPoint());
        txtIdVentas.setText(tableVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_tableVentasMouseClicked

    private void btnPdfVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfVentaActionPerformed
        try {
            int id = Integer.parseInt(txtIdVentas.getText());
            File file = new File("src/main/java/pdf/venta_"+id+".pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPdfVentaActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        routes.setSelectedIndex(4);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void limpiarTxtVenta(){
        txtCodigoVenta.setText("");
        txtDescripcionVenta.setText("");
        txtCantidadVenta.setText("");
        txtStockDisponible.setText("");
        txtPrecioVenta.setText("");
        txtIdVenta.setText("");
    }
    
    public void limpiarTxtProveedor() {
        txtRFC.setText("");
        txtNombreProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtTelefonoProveedor.setText("");
    }
    
    public void limpiarTxtProducto() {
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtCantProducto.setText("");
        txtPrecioProducto.setText("");
        cbxProveedorProducto.setSelectedItem("");
    }
    
    private void totalPagar() {
        tPagar = 0.0;
        int numFila = tableVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = (double) tableVenta.getModel().getValueAt(i, 4);
            tPagar = tPagar + cal;
        }
        lblTotalVenta.setText(String.format("%.2f", tPagar));
    }
    
    private void registrarVenta() {
        String vendedor = txtVendedor.getText();
        double monto = tPagar;
        v.setVendedor(vendedor);
        v.setTotal(monto);
        vDAO.registrarVenta(v);
    }
    
    private void registrarDetalle() {
        int id = vDAO.idVenta();
        for (int i = 0; i < tableVenta.getRowCount(); i++) {
            String cod = tableVenta.getValueAt(i, 0).toString();
            int cantidad = (int) tableVenta.getValueAt(i, 2);
            double precio = (double) tableVenta.getValueAt(i, 3);
            dv.setCod_prod(cod);
            dv.setCantidad(cantidad);
            dv.setPrecio(precio);
            dv.setId_venta(id);
            vDAO.registrarDetalle(dv);
        }
    }
    
    private void actualizarStocK()  {
        for (int i = 0; i < tableVenta.getRowCount(); i++) {
            String codigo = tableVenta.getValueAt(i, 0).toString();
            int cant = (int) tableVenta.getValueAt(i, 2);
            pd = pdDAO.buscarPorducto(codigo);
            int stockActual = pd.getStock() - cant;
            vDAO.actualizarStock(stockActual, codigo);
        }
    }
    
    private void limpiarTableVentas() {
        tmp = (DefaultTableModel) tableVenta.getModel();
        int fila = tableVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }
    
    private void PDF() {
        try {
            int id = vDAO.idVenta();
            FileOutputStream archivo;
            File file = new File("src/main/java/pdf/venta_"+id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/main/resources/icons/logo.png");
            
            Paragraph fecha = new Paragraph();
            Font negrita =new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: "+id+"\nFecha: " + new SimpleDateFormat("dd-mm-yyyy").format(date)+"\n\n");
            
            PdfPTable head = new PdfPTable(4);
            head.setWidthPercentage(100);
            head.getDefaultCell().setBorder(0);
            float[] columnHead = new float[]{20f, 30f, 70f, 40f};
            head.setWidths(columnHead);
            head.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            head.addCell(img);
            
            String rfc = txtRfcConf.getText();
            String nombre = txtNombreConf.getText();
            String telefono = txtTelefonoConf.getText();
            String direccion = txtDireccionConf.getText();
            
            head.addCell("");
            head.addCell("RFC: " + rfc + "\nNombre: " + nombre + "\nTelefono: " + telefono + "\nDireccion: " + direccion);
            head.addCell(fecha);
            doc.add(head);
            
            PdfPTable tablePro = new PdfPTable(4);
            tablePro.setWidthPercentage(100);
            tablePro.getDefaultCell().setBorder(0);
            float[] columnPro = new float[]{20f,50f,30f,40f};
            tablePro.setWidths(columnPro);
            tablePro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Cantidad"));
            PdfPCell pro2 = new PdfPCell(new Phrase("Descripcion"));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio U."));
            PdfPCell pro4 = new PdfPCell(new Phrase("Precio T."));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            tablePro.addCell(pro1);
            tablePro.addCell(pro2);
            tablePro.addCell(pro3);
            tablePro.addCell(pro4);
            for (int i = 0; i < tableVenta.getRowCount(); i++) {
                String producto = tableVenta.getValueAt(i, 1).toString();
                String cantidad = tableVenta.getValueAt(i, 2).toString();
                String precio = tableVenta.getValueAt(i, 3).toString();
                String total = tableVenta.getValueAt(i, 4).toString();
                tablePro.addCell(cantidad);
                tablePro.addCell(producto);
                tablePro.addCell(precio);
                tablePro.addCell(total);
            }
            doc.add(tablePro);
            
            Paragraph info  = new  Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total  Pagar: " + tPagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph msj = new Paragraph();
            msj.add(Chunk.NEWLINE);
            msj.add("Gracias Por Su Compra");
            msj.setAlignment(Element.ALIGN_CENTER);
            doc.add(msj);
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.err.println(e.toString());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton btnActualizarConf;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnExcelProducto;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnPdfVenta;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> cbxProveedorProducto;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConfiguracion;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JPanel panelConfiguracion;
    private javax.swing.JPanel panelNuevaVenta;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelProveedores;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTabbedPane routes;
    private javax.swing.JTable tableProducto;
    private javax.swing.JTable tableProveedor;
    private javax.swing.JTable tableVenta;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtCantProducto;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtDireccionConf;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtIdConf;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtIdVentas;
    private javax.swing.JTextField txtNombreConf;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRfcConf;
    private javax.swing.JTextField txtStockDisponible;
    private javax.swing.JTextField txtTelefonoConf;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JLabel txtVendedor;
    // End of variables declaration//GEN-END:variables
}
