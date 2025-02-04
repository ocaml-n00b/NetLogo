// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.agent.Agent;
import org.nlogo.agent.AgentSet;
import org.nlogo.agent.Turtle;
import org.nlogo.core.AgentKindJ;
import org.nlogo.core.I18N;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.RuntimePrimitiveException;
import org.nlogo.nvm.Reporter;

import java.util.List;

public final class _incone
    extends Reporter {

  @Override
  public Object report(final Context context) {
    return report_1(context, argEvalAgentSet(context, 0),
        argEvalDoubleValue(context, 1),
        argEvalDoubleValue(context, 2));
  }

  public AgentSet report_1(final Context context, AgentSet sourceSet,
                           double radius, double angle) {
    if (sourceSet.kind() == AgentKindJ.Link()) {
      throw new RuntimePrimitiveException
          (context, this, I18N.errorsJ().get("org.nlogo.prim.etc.$common.expectedTurtleOrPatchButGotLink"));
    }
    if (radius < 0) {
      throw new RuntimePrimitiveException(context, this,
          I18N.errorsJ().getN("org.nlogo.prim.etc.$common.noNegativeRadius", displayName()));
    }
    if (angle < 0) {
      throw new RuntimePrimitiveException(context, this,
          I18N.errorsJ().getN("org.nlogo.prim.etc.$common.noNegativeAngle", displayName()));
    }
    if (angle > 360) {
      throw new RuntimePrimitiveException(context, this,
          I18N.errorsJ().getN("org.nlogo.prim.etc.$common.noAngleGreaterThan360", displayName()));

    }
    List<Agent> result =
        world.inRadiusOrCone().inCone((Turtle) context.agent, sourceSet, radius, angle, true);
    return AgentSet.fromArray
      (sourceSet.kind(), result.toArray(new Agent[result.size()]));
  }
}
