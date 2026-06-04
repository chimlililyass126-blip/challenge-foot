import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 10,         // 10 utilisateurs virtuels
  duration: '5s',  // pendant 5 secondes
};

export default function () {
  // host.docker.internal permet à K6 d'aller taper sur ton site qui tourne dans Docker sous Windows
  http.get('http://host.docker.internal:8082/');
  sleep(1);
}