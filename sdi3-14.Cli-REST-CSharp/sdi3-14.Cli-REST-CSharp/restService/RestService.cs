using Newtonsoft.Json;
using sdi3_14.Cli_REST_CSharp.dto;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_REST_CSharp.restService
{
    public class RestService
    {

        private String encodedCredentials;
        private User user = null;

        public RestService(String user, String password)
        {
            encodedCredentials = "Basic " + System.Convert.ToBase64String(System.Text.Encoding.GetEncoding("ISO-8859-1").GetBytes(user + ":" + password));

        }

        public User login()
        {
            User u = null;
            
            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/user");
            webrequest.Method = "GET";
            webrequest.ContentType = "application/json";
            
            webrequest.Headers.Add("Authorization", encodedCredentials);

            string result;

            try
            {
                using (WebResponse response = webrequest.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                    {
                        result = reader.ReadToEnd();
                    }
                }

            }
            catch (WebException e)
            {
                return null;
            }


            u = JsonConvert.DeserializeObject<User>(result);

            user = u;

            return u;
        }

        public dto.Task createTask(dto.Task tarea)
        {
            string parsedTask = JsonConvert.SerializeObject(tarea);

            dto.Task responseTask = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/users/" + user.id + "/tasks");
            webrequest.Method = "POST";
            webrequest.ContentType = "application/json";

            webrequest.Headers.Add("Authorization", encodedCredentials);

            string result;

            try
            {
                using (WebResponse response = webrequest.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                    {
                        result = reader.ReadToEnd();
                    }
                }

            }
            catch (WebException e)
            {
                return null;
            }


            responseTask = JsonConvert.DeserializeObject<dto.Task>(result);

            return responseTask;

        }

        public List<Category> findCategoriesByUserID(long id)
        {

            List < Category > categories = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/users/" + user.id + "/categories");
            webrequest.Method = "GET";
            webrequest.ContentType = "application/json";

            webrequest.Headers.Add("Authorization", encodedCredentials);

            string result;

            try
            {
                using (WebResponse response = webrequest.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                    {
                        result = reader.ReadToEnd();
                    }
                }

            }
            catch (WebException e)
            {
                return null;
            }


            categories = JsonConvert.DeserializeObject<List<Category>>(result);

            return categories;
        }

        public void markTaskAsFinished(long id)
        {

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/tasks/" + id);
            webrequest.Method = "PUT";
            //webrequest.ContentType = "application/json";

            webrequest.Headers.Add("Authorization", encodedCredentials);

            string result;

            try
            {
                WebResponse response = webrequest.GetResponse();
                //if(response.)
            }
            catch (WebException e)
            {
                System.Console.WriteLine("No se ha podido marcar la tarea");
            }

        }

        public List<dto.Task> getTasksFromCategoryId(long id)
        {

            List<dto.Task> categories = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create("http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs/categories/" + id + "/tasks");
            webrequest.Method = "GET";
            webrequest.ContentType = "application/json";

            webrequest.Headers.Add("Authorization", encodedCredentials);

            string result;

            try
            {
                using (WebResponse response = webrequest.GetResponse())
                {
                    using (StreamReader reader = new StreamReader(response.GetResponseStream()))
                    {
                        result = reader.ReadToEnd();
                    }
                }

            }
            catch (WebException e)
            {
                return null;
            }


            categories = JsonConvert.DeserializeObject<List<dto.Task>>(result);

            return categories;
        }
    }
}
