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
            IEnumerable<ejbClientUser> users = service.findAllUsersEjbClient();

            foreach (ejbClientUser u in users)
            {
                printUser(u);
            }
        }

        private static void printUser(ejbClientUser u)
        {
            Console.Write("Id: " + u.id);
            Console.Write(" - Login: " + u.login);
            Console.Write(" - Email: " + u.email);
            Console.Write(" - Administrador: " + u.isAdmin);
            Console.Write(" - Status: " + u.status);
            if (!u.isAdmin)
            {
                Console.Write(" - Completadas: " + u.tareasCompletadas);
                Console.Write(" - Completadas retrasadas: " + u.tareasCompletadasRetrasadas);
                Console.Write(" - Planificadas: " + u.tareasPlanificadas);
                Console.Write(" - No planificadas: " + u.tareasSinPlanificar);
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
