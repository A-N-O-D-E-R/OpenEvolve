package bio.anode.ale.service.fluidic.circuit;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

import bio.anode.ale.core.exception.IllegalTopologyException;
import bio.anode.ale.core.usage.fluidic.Connection;
import bio.anode.ale.core.usage.fluidic.valve.DiverterUsage;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FluidicPathVisitor {
    private Stack<Connection> followedPath = new Stack<Connection>();
    private boolean cyclic;
	private Set<Serializable> visitedComposantFluidiqueUsageIds = new HashSet<Serializable>();

	public FluidicPathVisitor(Connection initialConnection) throws IllegalTopologyException {
		cyclic=false;
		visitedComposantFluidiqueUsageIds.add(initialConnection.getRoot().getId());
        forward(initialConnection);
	}

	public void forward(Connection connection) throws IllegalTopologyException {
		// TODO : revoir l'algorithme pour supprimer le lien specifique vers
		// AiguillageUsage
		if (!visitedComposantFluidiqueUsageIds.add(connection.getTarget().getId()))
			if (!(connection.getTarget() instanceof DiverterUsage) || ((DiverterUsage) connection.getTarget()).getNextConnection(connection.getTargetConnector()) != null) {
				cyclic=true;
				log.error(fullPathToString());
				throw new IllegalTopologyException("Cycle trouve a partir de " + connection.getTarget().getName() + " " + connection.getTarget().getId()+"\n"+visitedComposantFluidiqueUsageIds);
			}

		followedPath.push(connection);
	}

	public void backward() {
		Connection removedConnection = followedPath.pop();
		visitedComposantFluidiqueUsageIds.remove(removedConnection.getTarget().getId());
	}

	public Connection getCurrentPosition() {
		return followedPath.peek();
	}

	public String currentPositionToString() {
		Connection lastConnectionFollowed = getCurrentPosition();
		return "Visiting " + lastConnectionFollowed.getTarget().getName() + " " + lastConnectionFollowed.getTarget().getId() + " from " + lastConnectionFollowed.getRoot().getName() + " " + lastConnectionFollowed.getRoot().getId();
	}

	public void traceCurrentPosition() {
		if (log.isDebugEnabled())
			log.debug(currentPositionToString());
	}

	public String fullPathToString() {

		StringBuffer buffer = new StringBuffer("Path : ");

		for (Connection connection : followedPath) {
			buffer.append(connection.getTarget().getName()).append("->");
		}

		return buffer.toString().substring(0, buffer.length() - 2);
	}

    public boolean isCyclic(){
        return cyclic;
    }
}
