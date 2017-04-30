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
        public long createdLong
        {
            get { return Convert.ToInt64(createdDate.ToUniversalTime().Subtract(new DateTime(1970, 1, 1).ToUniversalTime()).TotalMilliseconds); }
            set { createdDate = new DateTime(1970, 1, 1).AddMilliseconds(value).ToLocalTime(); }

        }

        [JsonIgnore]
        public DateTime createdDate
        {
            get;
            set;
        }

        [JsonProperty("planned")]
        public long plannedLong
        {
            get { return Convert.ToInt64(plannedDate.ToUniversalTime().Subtract(new DateTime(1970, 1, 1).ToUniversalTime()).TotalMilliseconds); }
            set { this.plannedDate = new DateTime(1970, 1, 1).AddMilliseconds(value).ToLocalTime(); }

        }

        [JsonIgnore]
        public DateTime plannedDate
        {
            get;
            set;
        }

        [JsonIgnore]
        public bool retarded { get; set; }
        /*
        public long finishedLong
        {
            get { return finished.Ticks; }
            set { this.finished = new DateTime(finishedLong); }

        }

        public DateTime finished
        {
            get;
            set;
        }
        */

        public override String ToString()
        {
            return "Tarea [id=" + id + ", titulo = " + title + ", comentarios = "
                    + comments + ", fecha de creacion = " + createdDate + ", fecha de planificacion = " + plannedDate
                    + "]";
        }

    }
}
