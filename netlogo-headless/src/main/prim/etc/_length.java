// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc;

import org.nlogo.core.LogoList;
import org.nlogo.core.Pure;
import org.nlogo.core.Syntax;
import org.nlogo.nvm.ArgumentTypeException;
import org.nlogo.nvm.Context;
import org.nlogo.nvm.Reporter;

public final class _length extends Reporter implements Pure {

  @Override
  public Object report(Context context) {
    Object obj = args[0].report(context);
    if (obj instanceof LogoList) {
      return report_2(context, (LogoList) obj);
    } else if (obj instanceof String) {
      return report_3(context, (String) obj);
    }
    throw new ArgumentTypeException
        (context, this, 0, Syntax.ListType() | Syntax.StringType(), obj);
  }

  public double report_1(Context context, Object obj) {
    if (obj instanceof LogoList) {
      return ((LogoList) obj).size();
    } else if (obj instanceof String) {
      return ((String) obj).length();
    }
    throw new ArgumentTypeException
        (context, this, 0, Syntax.ListType() | Syntax.StringType(), obj);
  }

  public double report_2(Context context, LogoList list) {
    return list.size();
  }

  public double report_3(Context context, String s) {
    return s.length();
  }
}
