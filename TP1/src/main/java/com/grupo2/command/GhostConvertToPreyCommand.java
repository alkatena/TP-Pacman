package com.grupo2.command;

import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public class GhostConvertToPreyCommand extends GhostCommand {

	GhostConvertToPreyCommand(IGhost ghost) {
            this.ghost = ghost;
	}

	@Override
	public boolean execute() {
            this.ghost.convertToPrey();
            return true;
	}

}