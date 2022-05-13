// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.core.AgentKindJ;
import org.nlogo.agent.AgentSet;
import org.nlogo.agent.Link;
import org.nlogo.agent.Turtle;
import org.nlogo.api.AgentException;
import org.nlogo.api.LogoException;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.Command;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;

public final class _layouttutte
    extends Command {
  public _layouttutte() {
    this.switches = true;
  }



  @Override
  public void perform(final Context context)
      throws LogoException {
    AgentSet nodeset = argEvalAgentSet(context, 0, AgentKindJ.Turtle());
    AgentSet linkset = argEvalAgentSet(context, 1, AgentKindJ.Link());
    double radius = argEvalDoubleValue(context, 2);
    try {
      org.nlogo.agent.Layouts.tutte(world, nodeset, linkset, radius,
          context.job.random);
    } catch (AgentException e) {
      throw new RuntimePrimitiveException(context, this, e.getMessage());
    }
    context.ip = next;
  }
}
