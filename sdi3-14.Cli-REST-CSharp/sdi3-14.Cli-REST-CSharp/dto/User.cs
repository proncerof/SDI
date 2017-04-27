using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.dto
{
    public enum UserStatus
    {
        ENABLED, DISABLED
    }

    [JsonObject]
    public class User
    {
        [JsonProperty("id")]
        public long id
        {
            get;
            set;
        }

        [JsonProperty("login")]
        public String login
        {
            get;
            set;
        }

        [JsonProperty("email")]
        public String email
        {
            get;
            set;
        }

        [JsonProperty("password")]
        public String password
        {
            get;
            set;
        }

        [JsonProperty("isAdmin")]
        public Boolean isAdmin
        {
            get;
            set;
        }

        [JsonProperty("status")]
        public UserStatus status
        {
            get;
            set;
        }

        public override String ToString()
        {
            return "User [id=" + id + ", login=" + login + ", email=" + email
                    + ", password=" + password + ", isAdmin=" + isAdmin + "]";
        }

    }
}
