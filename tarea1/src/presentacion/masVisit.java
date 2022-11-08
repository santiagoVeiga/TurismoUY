package presentacion;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import logica.DataVisitas;
import logica.IControladorConsulta;

public class masVisit extends JInternalFrame {
	private JTable table;
	private IControladorConsulta cCons;
	
	public masVisit(IControladorConsulta ccc) {
		cCons= ccc;
        setClosable(true);
        setBounds(223, 15, 694, 408);
        setVisible(false);
        String[][] aaa = new String[10][4];
        for(int i = 0; i<10; i++) {
        	for (int j = 0; j<4; j++) {
        		aaa[i][j] = "";
        	}
        }
        List<DataVisitas> res = ccc.diezMasVisitadas();
        int cont = 0;
        for (DataVisitas iter : res) {
        	aaa[cont][0] = iter.getNombre();
        	aaa[cont][1] = iter.getProv();
        	aaa[cont][3] = Integer.toString(iter.getCantVis());
        	cont++;
        }
        table = new JTable();
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"#", "Actividad/Salida Turistica", "Proveedor Actividad", "Tipo", "Cantidad de Visitas"},
        		{1,aaa[0][0], aaa[0][1], aaa[0][2], aaa[0][3]},
        		{2,aaa[1][0], aaa[1][1], aaa[1][2], aaa[1][3] },
        		{3,aaa[2][0], aaa[2][1], aaa[2][2], aaa[2][3] },
        		{4,aaa[3][0], aaa[3][1], aaa[3][2], aaa[3][3] },
        		{5,aaa[4][0], aaa[4][1], aaa[4][2], aaa[4][3] },
        		{6,aaa[5][0], aaa[5][1], aaa[5][2], aaa[5][3] },
        		{7,aaa[6][0], aaa[6][1], aaa[6][2], aaa[6][3] },
        		{8, aaa[7][0], aaa[7][1], aaa[7][2], aaa[7][3]},
        		{9,aaa[8][0], aaa[8][1], aaa[8][2], aaa[8][3] },
        		{10,aaa[9][0] ,aaa[9][1], aaa[9][2], aaa[9][3] },
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

public void actualizarTabla() {
	String[][] aaa = new String[10][4];
    for(int i = 0; i<10; i++) {
    	for (int j = 0; j<4; j++) {
    		aaa[i][j] = "";
    	}
    }
	List<DataVisitas> res = cCons.diezMasVisitadas();
    int cont = 0;
    for (DataVisitas iter : res) {
    	aaa[cont][0] = iter.getNombre();
    	aaa[cont][1] = iter.getProv();
    	aaa[cont][3] = Integer.toString(iter.getCantVis());
    	cont++;
    }
    table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"#", "Actividad/Salida Turistica", "Proveedor Actividad", "Tipo", "Cantidad de Visitas"},
        		{1,aaa[0][0], aaa[0][1], aaa[0][2], aaa[0][3]},
        		{2,aaa[1][0], aaa[1][1], aaa[1][2], aaa[1][3] },
        		{3,aaa[2][0], aaa[2][1], aaa[2][2], aaa[2][3] },
        		{4,aaa[3][0], aaa[3][1], aaa[3][2], aaa[3][3] },
        		{5,aaa[4][0], aaa[4][1], aaa[4][2], aaa[4][3] },
        		{6,aaa[5][0], aaa[5][1], aaa[5][2], aaa[5][3] },
        		{7,aaa[6][0], aaa[6][1], aaa[6][2], aaa[6][3] },
        		{8, aaa[7][0], aaa[7][1], aaa[7][2], aaa[7][3]},
        		{9,aaa[8][0], aaa[8][1], aaa[8][2], aaa[8][3] },
        		{10,aaa[9][0] ,aaa[9][1], aaa[9][2], aaa[9][3] },
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
}
}
