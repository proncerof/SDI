using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.dto
{
    [JsonObject]
    public class Category
    {
        [JsonProperty("id")]
        public long id
        {
            get;
            set;
        }

        [JsonProperty("name")]
        public String name
        {
            get;
            set;
        }
        
        public override String ToString()
        {
            return "Category [id=" + id + ", name=" + name + "]";
        }

    }
}
