using sdi3_14.Cli_REST_CSharp.dto;
using sdi3_14.Cli_REST_CSharp.menu.menuItems;
using sdi3_14.Cli_REST_CSharp.restService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.menu
{
    public abstract class MainMenuItem : MenuItem
    {
        protected RestService restService;
        protected User user;

        public MainMenuItem(RestService restService, User user)
        {
            this.restService = restService;
            this.user = user;
        }

        IList<MenuItem> MenuItem.Execute()
        {

            executeInternal();

            List<MenuItem> items = new List<MenuItem>();

            items.Add(new ListCategoriesMenuItem(restService, user));
            items.Add(new ListTaskFromCategoryIdMenuItem(restService, user));
            items.Add(new CreateTaskMenuItem(restService, user));
            items.Add(new MarkTaskAsFinishedMenuItem(restService, user));

            return items;
        }

        public abstract String GetMenuName();

        protected abstract void executeInternal();
    }
}
