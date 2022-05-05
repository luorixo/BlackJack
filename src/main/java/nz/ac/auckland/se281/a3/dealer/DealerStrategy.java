package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Player;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface DealerStrategy {
	Action decideAction();
}
