package _422.studentsystem.model;

import _422.studentsystem.bean.Student;
import _422.studentsystem.dao.ManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class StudentModel extends AbstractTableModel {
	private ManageHelper helper;
	private Vector<Student> students;
	//rowData�������������
	//columnNames�������
	private  Vector<String> columnNames = null;
	private Vector<Vector<String>> rowData = null;
	
		
	 public StudentModel(String sql,JDialog jd) {
		helper = new ManageHelper();
		students = helper.getStudent(sql);
		
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("�꼶");
		columnNames.add("�༶");
		columnNames.add("Ժϵ");
		columnNames.add("רҵ");
		for(Student student : students){
			Vector<String> hang = new Vector<String>();
			hang.add(student.getStudent_ID());
			hang.add(student.getStudent_Name());
			hang.add(student.getSex());
			hang.add(student.getGrade());
			hang.add(student.getClasse());
			hang.add(student.getDepartment_Name());
			hang.add(student.getMajor_Name());
			rowData.add(hang);
		}
		if(getRowCount()!=0){
			JOptionPane.showMessageDialog(jd, "һ����"+getRowCount()+"����¼��");
			return ;
		}else{
			JOptionPane.showMessageDialog(jd, "û���κμ�¼��");
			return ;
		}
	}
	
		//�õ����ж�����
		@Override
		public int getRowCount() {
			return this.rowData.size();
		}
		//�õ����ж�����
		@Override
		public int getColumnCount() {
			return this.columnNames.size();
		}
		//�õ�ĳ��ĳ�е�����
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
		}
		
		//��д���� getColumnName
		@Override  
		public String getColumnName(int column) {
			return (String)this.columnNames.get(column);
		}
}
