package presentacion;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class masVisit extends JInternalFrame {
	private JTable table;
	
	public masVisit() {
        setClosable(true);
        setBounds(223, 15, 694, 408);
        setVisible(false);
        
        
        table = new JTable();
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"#", "Actividad/Salida Turistica", "Proveedor Actividad", "Tipo", "Cantidad de Visitas"},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"#", "Actividad/Salida Turistica", "Proveedor Actividad", "Tipo", "Cantidad de Visitas"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        getContentPane().add(table, BorderLayout.CENTER);
	}
}
