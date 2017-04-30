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
        private const string URL_BASE = "http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs";


        private String encodedCredentials;
        private Int64? userId;

        public RestService(String user, String password)
        {
            encodedCredentials = "Basic " + System.Convert.ToBase64String(System.Text.Encoding.GetEncoding("ISO-8859-1").GetBytes(user + ":" + password));

        }

        public Int64? login()
        {
            Int64? u = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create(URL_BASE + "/login");
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


            u = JsonConvert.DeserializeObject<Int64?>(result);

            userId = u;

            return u;
        }

        public dto.Task createTask(dto.Task tarea, long catId)
        {
            string parsedTask = JsonConvert.SerializeObject(tarea);

            dto.Task responseTask = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create(URL_BASE + "/users/" + userId + "/categories/" + catId + "/tasks");
            webrequest.Method = "POST";
            

            webrequest.Headers.Add("Authorization", encodedCredentials);

            byte[] bytes = Encoding.ASCII.GetBytes(parsedTask);

            var newStream = webrequest.GetRequestStream();
            newStream.Write(bytes, 0, bytes.Length);
            newStream.Close();
            webrequest.ContentType = "application/json";

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

        public List<Category> findCategoriesByUserID()
        {

            List<Category> categories = null;

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create(URL_BASE + "/users/" + userId + "/categories");
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

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create(URL_BASE + "/users/" + userId + "/tasks/" + id);
            webrequest.Method = "PUT";
            webrequest.ContentType = "application/json";

            webrequest.Headers.Add("Authorization", encodedCredentials);

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

            System.Net.HttpWebRequest webrequest = (HttpWebRequest)System.Net.WebRequest.Create(URL_BASE + "/users/" + userId + "/categories/" + id + "/tasks");
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
