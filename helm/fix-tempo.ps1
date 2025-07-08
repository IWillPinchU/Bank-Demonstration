kubectl delete pvc data-tempo-grafana-tempo-ingester-0 --namespace default
helm uninstall tempo
cd "D:\Spring\MicroServices\section16\helm"
helm upgrade --install tempo grafana-tempo --namespace default --set persistence.enabled=false
