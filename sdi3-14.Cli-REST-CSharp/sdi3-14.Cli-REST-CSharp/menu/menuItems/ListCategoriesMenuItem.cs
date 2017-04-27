using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu.menuItems
{
    class ListCategoriesMenuItem : MainMenuItem
    {

        public ListCategoriesMenuItem(RestService restService, User user) : base(restService, user)
        {
        }

        public override String GetMenuName()
        {
            return "Ver categorias";
        }

        protected override void executeInternal()
        {

            List<Category> categories = restService.findCategoriesByUserID(user
                    .id);

            foreach (Category c in categories)
            {
                System.Console.WriteLine(c);
            }

        }

    }
}
