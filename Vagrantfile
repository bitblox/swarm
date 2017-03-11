# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

  if (/cygwin|mswin|mingw|bccwin|wince|emx/ =~ RUBY_PLATFORM) != nil
    config.vm.synced_folder ".", "/vagrant", mount_options: ["dmode=700,fmode=600"]
  else
    config.vm.synced_folder ".", "/vagrant"
  end

  config.vm.define "skynet" do |d|
    d.vm.box = "ubuntu/trusty64"
    d.vm.hostname = "skynet"
    # jenkins
    d.vm.network "forwarded_port", guest: 8080, host: 9000
    # docker registry
    d.vm.network "forwarded_port", guest: 5000, host: 5000
    d.vm.network "private_network", ip: "10.100.198.200"
    d.vm.provision :shell, path: "scripts/bootstrap_ansible.sh"
    d.vm.provision :shell, inline: "PYTHONUNBUFFERED=1 ansible-playbook /vagrant/ansible/skynet.yml -c local"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end

  config.vm.define "scm" do |d|
    d.vm.box = "ubuntu/trusty64"
    d.vm.hostname = "scm"
    d.vm.network "forwarded_port", guest: 80, host: 9001
    d.vm.network "private_network", ip: "10.100.198.201"
    d.vm.provision :shell, path: "scripts/bootstrap_ansible.sh"
    d.vm.provision :shell, inline: "PYTHONUNBUFFERED=1 ansible-playbook /vagrant/ansible/scm.yml -c local"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end

  config.vm.define "logging" do |d|
    d.vm.box = "ubuntu/trusty64"
    d.vm.hostname = "logging"
    d.vm.network "forwarded_port", guest: 5601, host: 9002
    d.vm.network "private_network", ip: "10.100.194.200"
    d.vm.provision :shell, path: "scripts/bootstrap_ansible.sh"
    d.vm.provision :shell, inline: "PYTHONUNBUFFERED=1 ansible-playbook /vagrant/ansible/logging.yml -c local"
    d.vm.provider "virtualbox" do |v|
      v.memory = 2048
    end
  end

  config.vm.define "swarm-master" do |d|
    d.vm.box = "ubuntu/xenial-cloud"
    d.vm.box_url = "http://cloud-images.ubuntu.com/xenial/current/xenial-server-cloudimg-amd64-vagrant.box"
    d.vm.hostname = "swarm-master"
    d.vm.network "private_network", ip: "10.100.194.201"
    d.vm.provision :shell, inline: "sudo apt-get install -y python"
    d.vm.provider "virtualbox" do |v|
      v.memory = 1024
    end
  end
  (2..3).each do |i|
    config.vm.define "swarm-node-#{i}" do |d|
      d.vm.box = "ubuntu/xenial-cloud"
      d.vm.box_url = "http://cloud-images.ubuntu.com/xenial/current/xenial-server-cloudimg-amd64-vagrant.box"
      d.vm.network "private_network", ip: "10.100.194.20#{i}"
      d.vm.hostname = "swarm-node-#{i}"
      d.vm.provision :shell, inline: "sudo apt-get install -y python"
      d.vm.provider "virtualbox" do |v|
        v.memory = 1536
        v.cpus = 1
      end
    end
  end

end
