package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cliente;
import model.Funcionario;
import model.Pacote;
import model.Pedidos;

public class PedidoDao {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet result = null;
	
	public void criarPedido(Pedidos pedidos) {
		String sql = "INSERT INTO pedidos (tipo_pacote, id_pacote, id_cliente, id_funcionario)" 
				+ " VALUES(?, ?, ?, ?)";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, pedidos.getPacote ().getTipo());
			pst.setInt(2, pedidos.getPacote().getId_Pacote());
			pst.setInt(3, pedidos.getCliente().getId_Cliente());
			pst.setInt(4, pedidos.getFuncionario().getId_Funcionario());
			
			pst.execute();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atualizarPedido(Pedidos pedidos) {
		String sql = "UPDATE pedidos SET tipo_pacote = ?, id_pacote = ?, id_cliente = ?, id_funcionario = ? WHERE id_pacote = ?";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, pedidos.getPacote().getTipo());
			pst.setInt(2, pedidos.getPacote().getId_Pacote());
			pst.setInt(3, pedidos.getCliente().getId_Cliente());
			pst.setInt(4, pedidos.getFuncionario().getId_Funcionario());
			pst.setInt(5, pedidos.getId_Pedido());
			pst.execute();
			
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deletarPedido(int id) {
		String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Pedidos> verPedidos(){
		String sql = "SELECT * FROM pedidos AS p "
					+ "JOIN pacotes AS pa ON p.id_pacote = pa.id_pacote\n"
					+ "JOIN cliente AS c ON p.id_cliente = c.id_cliente\n"
					+ "JOIN funcionarios AS f ON p.id_funcionario = f.id_funcionario";
		
		List<Pedidos> pedido = new ArrayList<Pedidos>();
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			result = pst.executeQuery();
			
			while(result.next()) {
				Pedidos pedido1 = new Pedidos();
				Pacote pacote = new Pacote();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				
				pedido1.setId_Pedido(result.getInt("id_pedido"));
				pacote.setTipo(result.getString("tipo_pacote"));
				pacote.setId_Pacote(result.getInt("id_pacote"));
				pedido1.setPacote(pacote);
				cliente.setId_Cliente(result.getInt("id_cliente"));
				pedido1.setCliente(cliente);
				funcionario.setId_Funcionario(result.getInt("id_funcionario"));
				pedido1.setFuncionario(funcionario);
				pedido.add(pedido1);
				
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
		return pedido;
	}
	
	public Pedidos selecionarPedido(int id){
		String sql = "SELECT * FROM pedidos AS p "
					+ "JOIN pacotes AS pa ON p.id_pacote = pa.id_pacote\n"
					+ "JOIN cliente AS c ON p.id_cliente = c.id_cliente\n"
					+ "JOIN funcionarios AS f ON f.id_funcionario = f.id_funcionario\n"
					+ "WHERE id_pedido = ?";
		
		Pedidos pedido1 = new Pedidos();
		Pacote pacote = new Pacote();
		Cliente cliente = new Cliente();
		Funcionario funcionario = new Funcionario();
			
			try {
				con = ConnectionFactory.createConnectionToMySql();
				pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				result = pst.executeQuery();
				
				result.next();
				pedido1.setId_Pedido(result.getInt("id_pedido"));
				pacote.setId_Pacote(result.getInt("id_pacote"));
				pacote.setTipo(result.getString("tipo_pacote"));
				pedido1.setPacote(pacote);
				cliente.setId_Cliente(result.getInt("id_cliente"));
				pedido1.setCliente(cliente);
				funcionario.setId_Funcionario(result.getInt("id_funcionario"));
				pedido1.setFuncionario(funcionario);	
				
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
			return pedido1;
	}
}
