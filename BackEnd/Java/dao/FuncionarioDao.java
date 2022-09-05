package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;
import model.Funcionario;

public class FuncionarioDao{
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet result = null;
	
	public void inserirFunc(Funcionario funcionarios) {
	String sql = "INSERT INTO funcionarios(nome, nivel_de_acesso, acesso, senha)"
			+ " VALUES(?,?,?,?)";
	
	try {
		con = ConnectionFactory.createConnectionToMySql();
		pst = con.prepareStatement(sql);
		
		pst.setString(1, funcionarios.getNome());
		pst.setString(2, funcionarios.getNivelAces());
		pst.setString(3, funcionarios.getAcesso());
		pst.setString(4, funcionarios.getSenha());
		pst.execute();
		
	}catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
		if(pst != null) {
			pst.close();
		}
		
		if(con != null) {
			con.close();
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
  }
	
	public void atualizarFunc(Funcionario funcionarios) {
		String sql = "UPDATE funcionarios SET nome = ?, nivel_de_acesso = ?, acesso = ?, senha = ?"
				+ " WHERE id_funcionario = ?";

		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, funcionarios.getNome());
			pst.setString(2, funcionarios.getNivelAces());
			pst.setString(3, funcionarios.getAcesso());
			pst.setString(4, funcionarios.getSenha());
			pst.setInt(5, funcionarios.getId_Funcionario());
			pst.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) {
					pst.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 }
	
	public void removerFunc(int id) {
		String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";

		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) {
					pst.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Funcionario> verFunc(){
		String sql = "SELECT * FROM funcionarios";
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			result = pst.executeQuery();
			
			while(result.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId_Funcionario(result.getInt("ID_FUNCIONARIO"));
				funcionario.setNome(result.getString("NOME"));
				funcionario.setNivelAces(result.getString("NIVEL_DE_ACESSO"));
				funcionario.setAcesso(result.getString("ACESSO"));
				funcionario.setSenha(result.getString("SENHA"));
				funcionarios.add(funcionario);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 if(result != null) {
					 result.close();
				 }
				 
				 if(pst != null) {
					 pst.close();
				 }
				 
				 if(con != null) {
					 con.close();
				 }
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
		 return funcionarios;
	}
	
	public Funcionario selecionarPorId(int id) {
		String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
		Funcionario f1 = new Funcionario();
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeQuery();
			
			if(result.next()) {
				f1.setId_Funcionario(result.getInt("id_funcionario"));
				f1.setNome(result.getString("nome"));
				f1.setNivelAces(result.getString("nivel_de_acesso"));
				f1.setAcesso(result.getString("acesso"));
				f1.setSenha(result.getString("senha"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(pst != null) {
					pst.close();
				}
				if(result != null) {
					result.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return f1;	
	} 
	
}