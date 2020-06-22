package ipn.mx.SystemHealth.SystemHealthF.WebController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.math.BigInteger;

import ipn.mx.SystemHealth.SystemHealthF.DAO.*;
import ipn.mx.SystemHealth.SystemHealthF.Model.*;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.ConfirmationTokenRepository;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IPacienteRepo;
import ipn.mx.SystemHealth.SystemHealthF.service.EmailSenderService;

@Controller
@EnableSpringDataWebSupport
public class webController {
	@Autowired
	private PacienteDAO pacientedao;
	@Autowired
	private DoctorDAO doctordao;
	@Autowired
	private UserDAO usuariodao;
	@Autowired
	private MedicamentoDAO medicamentodao;
	@Autowired
	private UserDAO userdao;
	@Autowired
	private RecetaDAO recetadao;
	@Autowired
	private CantidadesDAO catidadesdao;
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	@Autowired
    private EmailSenderService emailSenderService;
	@Autowired
	private MunicipioDAO municipiosdao;
	@Autowired
	private EntidadDAO entidadesdao;
	@Autowired
	private ConsultorioDAO consultoriodao;
	@Autowired
	DataSource dataSource;

	private boolean primero = true;
	private boolean map = true;
	
	@PersistenceContext
    private EntityManager em;

	@GetMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping({ "/form" })
	public String form(Model model) {
		model.addAttribute("valor", 0);
		model.addAttribute("accion", "/sform");
		model.addAttribute("usuario", new Usuario());
		return "form";
	}

	@RequestMapping({ "/form/{pacienteId}" })
	public String ActualizarDatos(@PathVariable int pacienteId, Model model) {
		paciente pac = new paciente();
		pac = pacientedao.getPaciente(pacienteId);
		User user = userdao.getUsuario(pac.getIdUsuario());
		Usuario usuario = new Usuario();
		usuario.setApellidos(pac.getApellidos());
		usuario.setEdad(pac.getEdad());
		usuario.setEmail(user.getEmail());
		usuario.setEstatura(pac.getEstatura());
		usuario.setNombre(pac.getNombre());
		usuario.setPassword(user.getPassword());
		usuario.setPeso(pac.getPeso());
		usuario.setRole(user.getRole());
		usuario.setSexo(pac.getSexo());
		usuario.setTipodesangre(pac.getTipoDeSangre());
		usuario.setUserName(user.getUserName());
		usuario.setIdPaciente(pacienteId);
		model.addAttribute("valor", 1);
		model.addAttribute("accion", "/sforma");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@RequestMapping({ "/formd/{pacienteId}" })
	public String ActualizarDatosPac(@PathVariable int pacienteId, Model model) {
		paciente pac = new paciente();
		pac = pacientedao.getPaciente(pacienteId);
		User user = userdao.getUsuario(pac.getIdUsuario());
		Usuario usuario = new Usuario();
		usuario.setApellidos(pac.getApellidos());
		usuario.setEdad(pac.getEdad());
		usuario.setEmail(user.getEmail());
		usuario.setEstatura(pac.getEstatura());
		usuario.setNombre(pac.getNombre());
		usuario.setPassword(user.getPassword());
		usuario.setPeso(pac.getPeso());
		usuario.setRole(user.getRole());
		usuario.setSexo(pac.getSexo());
		usuario.setTipodesangre(pac.getTipoDeSangre());
		usuario.setUserName(user.getUserName());
		usuario.setIdPaciente(pacienteId);
		model.addAttribute("valor", 1);
		model.addAttribute("accion", "/sformad");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@GetMapping({ "/paciente" })
	public String paciente(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		paciente pac = new paciente();
		User user = new User();
		user = usuariodao.getUsuario(auth.getName());

		byte[] bytes;
		String base64Encoded = "";
		try {
			bytes = user.getPhoto().getBytes(1, (int) user.getPhoto().length());
			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (SQLException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pac = pacientedao.getPacByUserId(auth.getName());

		model.addAttribute("imagen", base64Encoded);
		model.addAttribute("paciente", pac);
		return "paciente";
	}

	@GetMapping({ "/doctor" })
	public String doctor(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		doctor doc = new doctor();
		User user = new User();
		user = usuariodao.getUsuario(auth.getName());

		byte[] bytes;
		String base64Encoded = "";
		try {
			bytes = user.getPhoto().getBytes(1, (int) user.getPhoto().length());
			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (SQLException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doc = doctordao.getDocByUserId(auth.getName());
		model.addAttribute("imagen", base64Encoded);
		model.addAttribute("doctor", doc);
		return "doctor";
	}

	@GetMapping({ "/doctor/listaMedicamentos" })
	public String listaMedicamentos(Model model) {
		model.addAttribute("medicamentos", medicamentodao.listarMedicamentos());
		return "listaMedicamentos";
	}

	@GetMapping({ "/doctor/listaPacientes" })
	public String lista(Model model) {
		model.addAttribute("pac", new paciente());
		model.addAttribute("pacientes", pacientedao.listar());
		return "listaPacientes";
	}

	@GetMapping({ "/doctor/listaDoctores" })
	public String listaDoctor(Model model) {
		model.addAttribute("pacientes", pacientedao.listar());
		return "listaDoctores";
	}

	@PostMapping({ "/sform" })
	public String postform(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttrs)
			throws IOException, SerialException, SQLException {
		User user = new User();
		byte[] arreglo = usuario.getPhoto().getBytes();
		user.setUserName(usuario.getUserName());
		user.setEmail(usuario.getEmail());
		user.setPassword(usuario.getPassword());
		user.setPhoto(new SerialBlob(arreglo));
		user.setRole("ROLE_PAC");
		user.setConfirmation(0);

		paciente pac = new paciente();
		pac.setNombre(usuario.getNombre());
		pac.setApellidos(usuario.getApellidos());
		pac.setEdad(usuario.getEdad());
		pac.setIdUsuario(usuario.getUserName());
		pac.setEstatura(usuario.getEstatura());
		pac.setPeso(usuario.getPeso());
		pac.setSexo(usuario.getSexo());
		pac.setTipoDeSangre(usuario.getTipodesangre());

		usuariodao.addUsuario(user);
		pacientedao.addPaciente(pac);
		

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Registro Completado!");
        mailMessage.setText("Registro Completado en SystemHealth");

        emailSenderService.sendEmail(mailMessage);
		redirectAttrs.addFlashAttribute("mensaje", "Usuario creado").addFlashAttribute("clase", "success");
		return "redirect:/login";
	}

	@PostMapping({ "/sforma" })
	public String postActualizar(@ModelAttribute Usuario usuario, RedirectAttributes redirect)
			throws IOException, SerialException, SQLException {
		User user = usuariodao.getUsuario(usuario.getUserName());
		byte[] arreglo = usuario.getPhoto().getBytes();
		user.setUserName(usuario.getUserName());
		user.setEmail(usuario.getEmail());
		user.setPassword(usuario.getPassword());
		user.setPhoto(new SerialBlob(arreglo));
		user.setRole("ROLE_PAC");
		user.setConfirmation(0);

		paciente pac = pacientedao.getPaciente(usuario.getIdPaciente());
		pac.setNombre(usuario.getNombre());
		pac.setApellidos(usuario.getApellidos());
		pac.setEdad(usuario.getEdad());
		pac.setIdUsuario(usuario.getUserName());
		pac.setEstatura(usuario.getEstatura());
		pac.setPeso(usuario.getPeso());
		pac.setSexo(usuario.getSexo());
		pac.setTipoDeSangre(usuario.getTipodesangre());

		usuariodao.addUsuario(user);
		pacientedao.addPaciente(pac);
		redirect.addFlashAttribute("mensaje", "Datos Actualizados").addFlashAttribute("clase", "success");

		return "redirect:/paciente";
	}
	
	@PostMapping({ "/sformad" })
	public String postActualizarPac(@ModelAttribute Usuario usuario, RedirectAttributes redirect)
			throws IOException, SerialException, SQLException {
		User user = usuariodao.getUsuario(usuario.getUserName());
		byte[] arreglo = usuario.getPhoto().getBytes();
		user.setUserName(usuario.getUserName());
		//user.setEmail(usuario.getEmail());
		//user.setPassword(usuario.getPassword());
		//user.setPhoto(new SerialBlob(arreglo));
		user.setRole("ROLE_PAC");
		user.setConfirmation(0);

		paciente pac = pacientedao.getPaciente(usuario.getIdPaciente());
		pac.setNombre(usuario.getNombre());
		pac.setApellidos(usuario.getApellidos());
		pac.setEdad(usuario.getEdad());
		pac.setIdUsuario(usuario.getUserName());
		pac.setEstatura(usuario.getEstatura());
		pac.setPeso(usuario.getPeso());
		pac.setSexo(usuario.getSexo());
		pac.setTipoDeSangre(usuario.getTipodesangre());

		usuariodao.addUsuario(user);
		pacientedao.addPaciente(pac);
		redirect
			.addFlashAttribute("mensaje", "Datos Actualizados")
			.addFlashAttribute("clase", "success");

		return "redirect:/dpaciente/"+pac.getIdPaciente();
	}

	@RequestMapping({ "/dpaciente/{pacienteId}" })
	public String postPacienteDat(@PathVariable int pacienteId, Model model) {
		paciente pac = new paciente();
		receta rec = new receta();
		pac = pacientedao.getPaciente(pacienteId);
		List<receta> recetas = recetadao.getRecByIdPaciente(pac.getIdPaciente());
		List<cantidades> can = new ArrayList<cantidades>();
		int i = 0, aux = 0, aux2 = 0;
		List<Integer> numeros = new ArrayList<Integer>();
		Map<cantidades, medicamento> maplist = new HashMap<cantidades, medicamento>();
		Map<cantidades, medicamento> cmaplist = new HashMap<cantidades, medicamento>();
		Map<Integer, Map<cantidades, medicamento>> mapofmap = new HashMap<Integer, Map<cantidades, medicamento>>();
		List<Map<cantidades, medicamento>> bl = new ArrayList<Map<cantidades, medicamento>>();

		System.out.println(recetas.size());
		if (recetas.size() != 0) 
		{
			for (int j = 0; j < recetas.size(); j++) 
			{
				aux = recetas.get(j).getNumReceta();
				System.out.println(mapofmap);
				if (j == 0) 
				{
					can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
					maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
							medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));
					numeros.add(aux);
				} 
				else 
				{
					if (aux2 != aux) 
					{
						bl.add(new HashMap<cantidades, medicamento>(maplist));
						// mapofmap.put(aux, );
						maplist.clear();
						numeros.add(aux);
						can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
						maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
								medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));

					} else 
					{
						can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
						maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
								medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));

					}
				}
				if (j == recetas.size() - 1)
					bl.add(new HashMap<cantidades, medicamento>(maplist));
				aux2 = aux;
				i++;
			}
			i = 0;
			for (Map<cantidades, medicamento> l : bl) 
			{
				mapofmap.put(numeros.get(i), l);
				i++;
			}
		}
		model.addAttribute("mapof", mapofmap);
		model.addAttribute("map", maplist);
		model.addAttribute("num", numeros);
		model.addAttribute("recetas", recetas);
		model.addAttribute("paciente", pac);
		return "dpaciente";
	}

	@RequestMapping({ "/receta/{pacienteId}" })
	public String postReceta(@PathVariable int pacienteId, Model model) {
		paciente pac = new paciente();
		pac = pacientedao.getPaciente(pacienteId);
		List<receta> rec;
		rec = recetadao.listarRecetas();
		int numrec = rec.get(rec.size() - 1).getNumReceta();
		// System.out.println(numrec);
		medicamento med = new medicamento();

		model.addAttribute("numReceta", numrec);
		model.addAttribute("pac", pac.getIdPaciente());
		model.addAttribute("medica", medicamentodao.listarMedicamentos());
		model.addAttribute("recetatables", new recetatables());
		return "receta";
	}

	@PostMapping({ "/sreceta" })
	public String receta(@ModelAttribute recetatables receta, RedirectAttributes redirectAttrs, Model model) {
		receta qrec = new receta();
		cantidades can = new cantidades();
		paciente pac = new paciente();
		List<cantidades> lcant = new ArrayList<cantidades>();
		// Cantidades data
		can.setCantidad(receta.getCantidadrec());
		can.setDescripcion(receta.getDescripcionrec());
		can.setIdMedicamento(receta.getIdmedicamentorec());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		doctor doc = new doctor();
		User user = new User();
		user = usuariodao.getUsuario(auth.getName());

		doc = doctordao.getDocByUserId(user.getUserName());
		// Id Doctor
		int idDoc = doc.getIdDoctor();
		// Num Receta
		int numeroReceta = receta.getNumRecetarec();
		System.out.println("id Doctor: " + idDoc);
		int idBoton = receta.getBoton();
		System.out.println("cantidad: " + receta.getCantidadrec());
		System.out.println("descripcion: " + receta.getDescripcionrec());
		System.out.println("id paciente: " + receta.getIdpacienterec());
		System.out.println("id medicamento: " + receta.getIdmedicamentorec());
		System.out.println("numReceta: " + receta.getNumRecetarec());
		System.out.println("id boton: " + receta.getBoton());
		catidadesdao.addCantidad(can);

		lcant = catidadesdao.listarCantidades();
		can = lcant.get(lcant.size() - 1);
		if (idBoton == 0 && primero) {
			numeroReceta += 1;
			primero = false;
		} else if (idBoton == 1 && primero) {
			numeroReceta += 1;
			primero = false;
		}

		qrec.setNumReceta(numeroReceta);
		qrec.setIdCantidades(can.getIdCantidades());
		qrec.setIdDoctor(idDoc);
		qrec.setIdPaciente(receta.getIdpacienterec());
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		// System.out.println(formatter.format(date));
		qrec.setFecha(date);

		recetadao.addReceta(qrec);

		pac = pacientedao.getPaciente(receta.getIdpacienterec());
		model.addAttribute("paciente", pac);

		if (idBoton == 0)
			return "redirect:/dpaciente/" + receta.getIdpacienterec();
		else
			return "redirect:/receta/" + receta.getIdpacienterec();
	}

	@RequestMapping({"/verReceta/{pacienteId}"})
	public String verRecetasPac(@PathVariable int pacienteId,Model model)
	{
		paciente pac = new paciente();
		receta rec = new receta();
		pac = pacientedao.getPaciente(pacienteId);
		List<receta> recetas = recetadao.getRecByIdPaciente(pac.getIdPaciente());
		List<Integer> numeros = new ArrayList<Integer>();
		List<cantidades> can = new ArrayList<cantidades>();
		Map<cantidades, medicamento> maplist = new HashMap<cantidades, medicamento>();
		Map<cantidades, medicamento> cmaplist = new HashMap<cantidades, medicamento>();
		Map<Integer, Map<cantidades, medicamento>> mapofmap = new HashMap<Integer, Map<cantidades, medicamento>>();
		List<Map<cantidades, medicamento>> bl = new ArrayList<Map<cantidades, medicamento>>();
		int i=0,aux=0,aux2=0;
		System.out.println(recetas.size());
		if (recetas.size() != 0) 
		{
			for (int j = 0; j < recetas.size(); j++) 
			{
				aux = recetas.get(j).getNumReceta();
				System.out.println(mapofmap);
				if (j == 0) 
				{
					can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
					maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
							medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));
					numeros.add(aux);
				} 
				else 
				{
					if (aux2 != aux) 
					{
						bl.add(new HashMap<cantidades, medicamento>(maplist));
						maplist.clear();
						numeros.add(aux);
						can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
						maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
								medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));

					} else 
					{
						can.add(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()));
						maplist.put(catidadesdao.getCantidad(recetas.get(j).getIdCantidades()),
								medicamentodao.getMedicamento(can.get(i).getIdMedicamento()));

					}
				}
				if (j == recetas.size() - 1)
					bl.add(new HashMap<cantidades, medicamento>(maplist));
				aux2 = aux;
				i++;
			}
			i = 0;
			for (Map<cantidades, medicamento> l : bl) 
			{
				mapofmap.put(numeros.get(i), l);
				i++;
			}
		}
		model.addAttribute("mapof", mapofmap);
		model.addAttribute("map", maplist);
		model.addAttribute("num", numeros);
		model.addAttribute("recetas", recetas);
		model.addAttribute("paciente", pac);
		return "verReceta";
	}
	
	@GetMapping({"/modificarMed/{idmedicamento}"})
	public String ModificarMedicamento(@PathVariable int idmedicamento,Model model)
	{
		medicamento med = medicamentodao.getMedicamento(idmedicamento);
		model.addAttribute("medicamento",med);
		return "medicamento";
	}
	
	@PostMapping({"/medicamentopost"})
	public String postModificarMed(@ModelAttribute medicamento med, RedirectAttributes redirect,Model model)
	{
		medicamento medi = medicamentodao.getMedicamento(med.getIdmedicamento());
		medi.setNombre(med.getNombre());
		medi.setDosis(med.getDosis());
		medicamentodao.addMedicamento(medi);
		model.addAttribute("medicamentos", medicamentodao.listarMedicamentos());
		return "listaMedicamentos";
	}
	
	@GetMapping({"/eliminarMed/{idmedicamento}"})
	public String eliminarMed(@PathVariable int idmedicamento, Model model)
	{
		medicamentodao.deleteMedicamento(idmedicamento);
		model.addAttribute("medicamentos", medicamentodao.listarMedicamentos());
		return "listaMedicamentos";
	}
	
	@GetMapping({"/grafica"})
	public String Grafica()
	{
		return "grafica";
	}
	
	@GetMapping({ "/consultorio/{doctorId}" })
	public String consultorio(HttpSession session, Model model, @PathVariable int doctorId) {
		consultorio cons = new consultorio();
		
		consultorio auxcons = consultoriodao.getConsultorioByIdDoc(doctorId);
		System.out.println("consultorio auxiliar:" + auxcons.getIdconsultorio());
		auxcons.setIdDoctor(doctorId);
		model.addAttribute("valor", auxcons.getIdconsultorio());
		model.addAttribute("consultorio",auxcons);
	
		model.addAttribute("estados", entidadesdao.listarEntidades());
		
		
		return "consultorio";
	}
	
	@GetMapping({"eliminarCons/{idcons}/{iddoc}"})
	public String eliminarCons(@PathVariable("idcons")int idcons,@PathVariable("iddoc")int iddoc)
	{
		System.out.println("eliminar cons "+idcons+iddoc);
		consultoriodao.deleteConsultorio(idcons);
		return "redirect:/consultorio/"+iddoc;
	}
	
	@RequestMapping({"/segundocombo/{id}"})
	@ResponseBody
	public List<municipio> PostReqCombo(@PathVariable String id)
	{
	return municipiosdao.listarMunicipiosByCveEnt(id);
	}
	
	@RequestMapping({"/datosConsultorio/{id}"})
	@ResponseBody
	public List<municipio> RequestCons(@PathVariable String id)
	{
		municipio mun = municipiosdao.getMunicpio(consultoriodao.getConsultorioByIdDoc(Integer.parseInt(id)).getIdMunicipio());
		List<municipio> aux = new ArrayList<municipio>();
		System.out.println(mun);
		aux.add(mun);
	return aux;
	}
	
	@PostMapping({"/registrarConsultorio"})
	public String postConsultorio(@ModelAttribute consultorio cons ) {
		System.out.println(cons.getIdMunicipio());
		System.out.println(cons.getIdDoctor());
		consultoriodao.addConsultorio(cons);
		
		return "redirect:/consultorio/"+cons.getIdDoctor();
	}
	
	@GetMapping({"/get-data"})
	public ResponseEntity<Map<String, Integer>> getPieChart()
	{
	    Map<String,Integer> graphData = new TreeMap<String,Integer>();
		@SuppressWarnings("unchecked")
		List<Object[]> data = em.createNativeQuery("select M.nombre, Count(*) AS 'cantidad'" + 
				"	from medicamento AS M" + 
				"    INNER JOIN cantidades AS C ON" + 
				"    M.idMedicamento = C.idMedicamento" +
				"   group by M.idMedicamento").getResultList();
		
		List<ContMed> med = data.stream().map(result -> new ContMed((String)result[0],((BigInteger) result[1]).intValue() ))
				.collect(Collectors.toList());
		for(ContMed lcont: med)
		{
			graphData.put(lcont.getMedicamento(),lcont.getCantidad());
		}
		
		return new ResponseEntity<>(graphData, HttpStatus.OK);
	}
	@RequestMapping({ "/reporte/{n}" })
	@ResponseBody
	public void getRpt1(HttpServletResponse response, @PathVariable int n) throws JRException, IOException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			java.io.InputStream jasperStream = this.getClass().getResourceAsStream("/reportes/reporteMomito.jasper");
			Map<String, Object> params = new HashMap<>();
			params.put("NumRec", n);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection);

			response.setContentType("application/x-pdf");
			response.setHeader("Content-disposition", "inline; filename=receta.pdf");

			final ServletOutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
