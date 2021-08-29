import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  listOffices() {
    return http.get('/offices');
  },

  getOffice(officeId) {
    return http.get(`/offices/${officeId}`);
  },

  updateOffice(office) {
    return http.put(`/offices/${office.officeId}`, office);
  },

  listAppointments() {
    return http.get('/appointments');
  },

  getAppointmentsByOffice(officeId) {
    return http.get(`/appointments/${officeId}`);
  },

  createAppointment(time, date, officeId) {
    const appointment = {
      "appointmentDate" : date,
      "appointmentId" : 0,
      "appointmentTime" : `${time}:00`,
      "appointmentType" : "",
      "dateOfBirth" : "",
      "firstName" : "",
      "gender" : "",
      "lastName" : "",
      "newPatient" : true,
      "officeId" : officeId,
      "patientCity" : "",
      "patientEmail" : "",
      "patientState" : "",
      "patientStreetAddress" : "",
      "patientZip" : 0,
      "phoneNumber" : ""
      };
    http.post('/appointments', appointment);
  }
}