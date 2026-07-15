import { useEffect, useState } from 'react';

interface StatusResponse {
  status: string;
  message: string;
}

function App() {
  const [data, setData] = useState<StatusResponse | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetch('http://localhost:8080/api/status')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Error al conectar con el servidor');
        }
        return response.json() as Promise<StatusResponse>;
      })
      .then((data) => {
        setData(data);
        setLoading(false);
      })
      .catch((err: Error) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  return (
    <div style={{ padding: '2rem', fontFamily: 'sans-serif' }}>
      <h1>Metricas GitHub</h1>
      <hr />
      <h2>Estado del Backend:</h2>
      {loading && <p>Conectando con el servidor Java...</p>}
      {error && <p style={{ color: 'red' }}> Error: {error}</p>}
      {data && (
        <div style={{ padding: '1rem', background: '#e6f4ea', borderRadius: '8px', color: '#137333' }}>
          <p><strong>Estado:</strong> {data.status}</p>
          <p><strong>Respuesta:</strong> {data.message}</p>
        </div>
      )}
    </div>
  );
}

export default App;
