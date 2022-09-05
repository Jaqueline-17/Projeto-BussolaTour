package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;

import java.sql.Date;

public class ClienteDao {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet result = null;
	
	public void criarCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome, data_nasc, sexo, cpf, telefone, email, senha)" 
					+ " VALUES(?,?,?,?,?,?,?)";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, cliente.getNome());
			pst.setDate(2, new Date((cliente.getDataNasc()).getTime()));
			pst.setString(3, cliente.getSexo());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());
			pst.setString(6, cliente.getEmail());
			pst.setString(7, cliente.getSenha());
			pst.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
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
	
	public void atualizarCliente(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, data_nasc = ?, sexo = ?, cpf = ?, telefone = ?, email = ?, senha = ?"
					+ " WHERE id_cliente = ?";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, cliente.getNome());			
			pst.setDate(2, new Date((cliente.getDataNasc()).getTime()));
			pst.setString(3, cliente.getSexo());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());
			pst.setString(6, cliente.getEmail());
			pst.setString(7, cliente.getSenha());
			pst.setInt(8, cliente.getId_Cliente());
			pst.execute();
			
		} catch(Exception e) {
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
	
	public void removerCliente(int id) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			pst.execute();
		} catch(Exception e) {
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
	public Cliente selecionarPorId(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
		Cliente c1 = new Cliente();
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeQuery();
			
			if(result.next()) {
				c1.setId_Cliente(result.getInt("id_cliente"));
				c1.setNome(result.getString("nome"));
				c1.setDataNasc(result.getDate("data_nasc"));
				c1.setSexo(result.getString("sexo"));
				c1.setCpf(result.getString("cpf"));
				c1.setTelefone(result.getString("telefone"));
				c1.setEmail(result.getString("email"));
				c1.setSenha(result.getString("senha"));
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
		return c1;	
	} 
	
	public List<Cliente> verClientes(){
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			result = pst.executeQuery();
			
			while(result.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId_Cliente(result.getInt("ID_CLIENTE"));
				cliente.setNome(result.getString("NOME"));
				cliente.setDataNasc(result.getDate("DATA_NASC"));
				cliente.setSexo(result.getString("SEXO"));
				cliente.setCpf(result.getString("CPF"));
				cliente.setTelefone(result.getString("TELEFONE"));
				cliente.setEmail(result.getString("EMAIL"));
				cliente.setSenha(result.getString("SENHA"));
				clientes.add(cliente);
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
		 return clientes;
	 }
}
