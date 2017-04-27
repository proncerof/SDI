using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.dto
{
    [JsonObject]
    public class Task
    {
        [JsonProperty("id")]
        public long id
        {
            get;
            set;
        }

        [JsonProperty("title")]
        public String title
        {
            get;
            set;
        }
        [JsonProperty("comments")]
        public String comments
        {
            get;
            set;
        }

        [JsonProperty("created")]
        public DateTime created
        {
            get;
            set;
        }

        [JsonProperty("planned")]
        public DateTime planned
        {
            get;
            set;
        }

        [JsonProperty("retarded")]
        public DateTime finished
        {
            get;
            set;
        }


        public override String ToString()
        {
            return "Task [id=" + id + ", title=" + title + ", comments="
                    + comments + ", created=" + created + ", planned=" + planned
                    + ", finished=" + finished + "]";
        }

    }
}
