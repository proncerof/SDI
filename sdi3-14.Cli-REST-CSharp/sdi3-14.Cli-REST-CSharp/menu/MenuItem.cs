using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu
{
    interface MenuItem
    {
        String GetMenuName();

        IList<MenuItem> Execute();
    }
}
