package org.vvgaming.harmegido.game;

import java.util.Date;

import org.vvgaming.harmegido.util.Copyable;

/**
 * Essa classe modela uma entidade jogador do jogo
 */
public class Player implements Copyable {

	private Object dispositivo; // como reconhecer o dispositivo do jogador?
	private TeamType time; // o time que o jogador pertence

	public TeamType getTime() {
		return time;
	}
	
	public void trocarDeTime(final TeamType novoTime) {
		this.time = novoTime;
	}
	
	/**
	 * Cria um encantamento a partir da data/hora passada como par�metro
	 * @param timestamp A data/hora que o encantamento aconteceu
	 * @return Um encantamento criado por este jogador
	 */
	public Enchantment encantar(final Date timestamp)
	{
		return Enchantment.from(this, timestamp);
	}
	
	/**
	 * Cria um desencantamento para o encantamento passado como par�metro
	 * @param encantamento O encantamento que est� sendo desencantado
	 * @param timestamp A data/hora que o desencantamento aconteceu
	 * @return O desencantamento criado por este jogador
	 */
	public Disenchantment desencantar(final Enchantment encantamento, final Date timestamp)
	{
		return Disenchantment.from(this, timestamp, encantamento);
	}
	
	@Override
	public Player copy() {
		final Player toReturn = new Player();
		toReturn.dispositivo = this.dispositivo;
		toReturn.time = this.time;
		return toReturn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dispositivo == null) ? 0 : dispositivo.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Player other = (Player) obj;
		if (dispositivo == null) {
			if (other.dispositivo != null) {
				return false;
			}
		}
		else if (!dispositivo.equals(other.dispositivo)) {
			return false;
		}
		return true;
	}

}
