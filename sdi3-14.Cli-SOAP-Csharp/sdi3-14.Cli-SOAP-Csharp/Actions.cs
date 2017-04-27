using sdi3_14.Cli_SOAP_Csharp.AdminService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sdi3_14.Cli_SOAP_Csharp
{
    class Actions
    {

        private static AdminServiceClient service = new AdminServiceClient();

        public static void listUsers()
        {
            IEnumerable<user> users = service.findAllUsers();

            foreach (user u in users)
            {
                printUser(u);
            }
        }

        private static void printUser(user u)
        {
            Console.Write("Id: " + u.id);
            Console.Write(" - Login: " + u.login);
            Console.Write(" - Email: " + u.email);
            Console.Write(" - Administrador: " + u.isAdmin);
            Console.Write(" - Status: " + u.status);
            if (!u.isAdmin)
            {
                Console.Write(" - Completadas: " + u.tasks.Count(t => t.finished != null));
                Console.Write(" - Completadas retrasadas: " + u.tasks.Count(t => t.finished != null && t.finished.CompareTo(t.planned) == -1));
                Console.Write(" - Planificadas: " + u.tasks.Count(t => t.planned != null));
                Console.Write(" - No planificadas: " + u.tasks.Count(t => t.planned == null));
            }

            Console.WriteLine();

        }

        public static void disableUser()
        {
            Console.Write("Id del usuario:");
            long id = Convert.ToInt64(Console.ReadLine());
            if (service.findUserById(id) != null)
                service.disableUserAsync(id);
            else
                Console.WriteLine("\tUsuario no encontrado");
        }

        public static void enableUser()
        {
            Console.Write("Id del usuario:");
            long id = Convert.ToInt64(Console.ReadLine());
            if (service.findUserById(id) != null)
                service.enableUserAsync(id);
            else
                Console.WriteLine("\tUsuario no encontrado");
        }

        public static void deleteUser()
        {

            Console.Write("Id del usuario:");
            long id = Convert.ToInt64(Console.ReadLine());
            if (service.findUserById(id) != null)
                service.deepDeleteUserAsync(id);
            else
                Console.WriteLine("\tUsuario no encontrado");
        }
    }
}
