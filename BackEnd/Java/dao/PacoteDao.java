package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Funcionario;
import model.Pacote;

public class PacoteDao {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet result = null;
	
	public void criarPacote(Pacote pacotes) {
		String sql = "INSERT INTO pacotes(tipo, partida, destino, horario_saida, horario_chegada, transporte)"
				+ " VALUES(?,?,?,?,?,?)";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, pacotes.getTipo());
			pst.setString(2, pacotes.getPartida());
			pst.setString(3, pacotes.getDestino());
			pst.setString(4, pacotes.getHorSaida());
			pst.setString(5, pacotes.getHorChegada());
			pst.setString(6, pacotes.getTransporte());
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
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	  }
		
	public void atualizarPacote(Pacote pacotes) {
		String sql = "UPDATE pacotes SET tipo = ?, partida = ?, destino = ?, horario_saida = ?, horario_chegada = ?, transporte = ? "
				+ " WHERE id_pacote = ?";
		
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			
			pst.setString(1, pacotes.getTipo());
			pst.setString(2, pacotes.getPartida());
			pst.setString(3, pacotes.getDestino());
			pst.setString(4, pacotes.getHorSaida());
			pst.setString(5, pacotes.getHorChegada());
			pst.setString(6, pacotes.getTransporte());
			pst.setInt(7, pacotes.getId_Pacote());
			pst.execute();
		}catch(Exception e) {
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
	
	public void removerPacote(int id) {
		String sql = "DELETE FROM pacotes WHERE id_pacote = ?";
		
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

	public List<Pacote> verPacotes(){
		String sql = "SELECT * FROM pacotes";
		List<Pacote> pacotes = new ArrayList<Pacote>();

		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			result = pst.executeQuery();
		
		while(result.next()) {
			Pacote pacote = new Pacote();
			
			pacote.setId_Pacote(result.getInt("ID_PACOTE"));
			pacote.setTipo(result.getString("TIPO"));
			pacote.setPartida(result.getString("PARTIDA"));
			pacote.setDestino(result.getString("DESTINO"));
			pacote.setHorSaida(result.getString("HORARIO_SAIDA"));
			pacote.setHorChegada(result.getString("HORARIO_CHEGADA"));
			pacote.setTransporte(result.getString("TRANSPORTE"));
			pacotes.add(pacote);
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
		 return pacotes;
	}
	
	public Pacote selecionarPorId(int id) {
		String sql = "SELECT * FROM pacotes WHERE id_pacote = ?";
		Pacote p1 = new Pacote();
		try {
			con = ConnectionFactory.createConnectionToMySql();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeQuery();
			
			if(result.next()) {
				p1.setId_Pacote(result.getInt("id_pacote"));
				p1.setTipo(result.getString("tipo"));
				p1.setPartida(result.getString("partida"));
				p1.setDestino(result.getString("destino"));
				p1.setHorSaida(result.getString("horario_saida"));
				p1.setHorChegada(result.getString("horario_chegada"));
				p1.setTransporte(result.getString("transporte"));
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
		return p1;	
	} 
}
